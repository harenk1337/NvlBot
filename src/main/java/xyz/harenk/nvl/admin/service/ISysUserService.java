package xyz.harenk.nvl.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.harenk.nvl.admin.domain.entity.SysUserEntity;
import xyz.harenk.nvl.admin.domain.req.SysUserAvatarDTO;
import xyz.harenk.nvl.admin.domain.req.SysUserLoginDTO;
import xyz.harenk.nvl.admin.domain.req.SysUserUpsertDTO;
import xyz.harenk.nvl.admin.domain.res.SysUserVO;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-29 17:39
 */
public interface ISysUserService extends IService<SysUserEntity> {
    SysUserVO login(SysUserLoginDTO sysUserLoginDTO);

    void logout(String token);

    void reset(SysUserUpsertDTO sysUserUpsertDTO);

    SysUserVO updateAvatar(SysUserAvatarDTO sysUserAvatarDTO);
}
