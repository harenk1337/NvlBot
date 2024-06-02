package xyz.harenk.nvl.admin.service.impl;

import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xyz.harenk.nvl.admin.domain.entity.SysUserEntity;
import xyz.harenk.nvl.admin.domain.req.SysUserAvatarDTO;
import xyz.harenk.nvl.admin.domain.req.SysUserLoginDTO;
import xyz.harenk.nvl.admin.domain.req.SysUserUpsertDTO;
import xyz.harenk.nvl.admin.domain.res.SysUserVO;
import xyz.harenk.nvl.admin.mapper.SysUserMapper;
import xyz.harenk.nvl.admin.service.ISysUserService;
import xyz.harenk.nvl.common.exceptions.BizException;

import java.util.Optional;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-29 17:40
 */
@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements ISysUserService {

    @Override
    public SysUserVO login(SysUserLoginDTO sysUserLoginDTO) {
        SysUserEntity sysUser = Optional.ofNullable(lambdaQuery()
                        .eq(SysUserEntity::getAccount, sysUserLoginDTO.getAccount())
                        .one())
                .orElseThrow(() -> new BizException("用户不存在"));

        boolean checkpw = BCrypt.checkpw(sysUserLoginDTO.getPassword(), sysUser.getPassword());
        if (!checkpw) {
            throw new BizException("密码错误，请检查输入!");
        }

        Long userId = sysUser.getId();
        StpUtil.login(userId);
        return SysUserVO.builder()
                .id(userId)
                .account(sysUser.getAccount())
                .avatarUrl(sysUser.getAvatarUrl())
                .token(StpUtil.getTokenValue())
                .build();
    }

    @Override
    public void logout(String token) {
        StpUtil.logoutByTokenValue(token);
    }

    @Override
    public void reset(SysUserUpsertDTO sysUserUpsertDTO) {
        SysUserEntity sysUser = Optional.ofNullable(lambdaQuery()
                        .eq(SysUserEntity::getAccount, sysUserUpsertDTO.getAccount())
                        .one())
                .orElseThrow(() -> new BizException("用户不存在"));

        String password = sysUser.getPassword();
        boolean checkpw = BCrypt.checkpw(sysUserUpsertDTO.getOldPassword(), password);
        if (!checkpw) {
            throw new BizException("密码错误，请检查输入!");
        }

        String newPassword = BCrypt.hashpw(sysUserUpsertDTO.getNewPassword(), BCrypt.gensalt());
        sysUser.setPassword(newPassword);

        this.updateById(sysUser);
    }

    @Override
    public SysUserVO updateAvatar(SysUserAvatarDTO sysUserAvatarDTO) {
        SysUserEntity sysUser = Optional.ofNullable(this.getById(sysUserAvatarDTO.getId()))
                .orElseThrow(() -> new BizException("用户不存在"));
        sysUser.setAvatarUrl(sysUserAvatarDTO.getAvatarUrl());

        boolean b = this.updateById(sysUser);
        if (!b) {
            throw new BizException("更新头像失败");
        }
        return SysUserVO.builder()
                .id(sysUser.getId())
                .account(sysUser.getAccount())
                .avatarUrl(sysUser.getAvatarUrl())
                .token(StpUtil.getTokenValue())
                .build();
    }
}
