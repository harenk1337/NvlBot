package xyz.harenk.nvl.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.harenk.nvl.admin.domain.PageResult;
import xyz.harenk.nvl.admin.domain.entity.UserEntity;
import xyz.harenk.nvl.admin.domain.req.UserPageQueryDTO;
import xyz.harenk.nvl.admin.domain.req.UserUpsertDTO;
import xyz.harenk.nvl.admin.mapper.UserMapper;
import xyz.harenk.nvl.admin.service.IUserService;
import xyz.harenk.nvl.common.exceptions.BizException;
import xyz.harenk.nvl.common.utils.PageUtils;

import java.util.List;
import java.util.Optional;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-29 16:33
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements IUserService {

    @Override
    public PageResult<UserEntity> pageQueryUser(UserPageQueryDTO pageQueryDTO) {
        Page<UserEntity> page = new Page<>(pageQueryDTO.getPage(), pageQueryDTO.getPageSize());
        LambdaQueryWrapper<UserEntity> queryWrapper = Wrappers.<UserEntity>lambdaQuery()
                .like(ObjectUtil.isNotEmpty(pageQueryDTO.getName()), UserEntity::getName, pageQueryDTO.getName())
                .like(ObjectUtil.isNotEmpty(pageQueryDTO.getAccount()), UserEntity::getAccount, pageQueryDTO.getAccount())
                .eq(ObjectUtil.isNotEmpty(pageQueryDTO.getRole()), UserEntity::getRole, pageQueryDTO.getRole())
                .orderByDesc(UserEntity::getRole, UserEntity::getStatus)
                .orderByAsc(UserEntity::getId);

        Page<UserEntity> userEntityPage = this.page(page, queryWrapper);
        return PageUtils.toPage(userEntityPage);
    }

    @Override
    public void upsert(UserUpsertDTO userUpsertDTO) {
        if (ObjectUtil.isNull(userUpsertDTO.getId())) {
            insertUser(userUpsertDTO);
        } else {
            updateUser(userUpsertDTO);
        }
    }

    private void insertUser(UserUpsertDTO userUpsertDTO) {
        UserEntity user = lambdaQuery().eq(UserEntity::getAccount, userUpsertDTO.getAccount()).one();
        if (ObjectUtil.isNotNull(user)) {
            throw new BizException("用户账号必须保持唯一，请检查输入！");
        }

        UserEntity userEntity = BeanUtil.toBean(userUpsertDTO, UserEntity.class, CopyOptions.create().ignoreNullValue());
        boolean save = this.save(userEntity);
        if (!save) {
            throw new BizException(StrUtil.format("用户 {} 新增失败!", userEntity.getName()));
        }
    }

    private void updateUser(UserUpsertDTO userUpsertDTO) {
        UserEntity u = Optional.ofNullable(this.getById(userUpsertDTO.getId()))
                .orElseThrow(() -> new BizException("用户不存在!"));

        UserEntity user = lambdaQuery().eq(UserEntity::getAccount, userUpsertDTO.getAccount()).one();
        if (ObjectUtil.notEqual(u, user)) {
            throw new BizException("用户账号必须保持唯一，请检查输入！");
        }

        BeanUtil.copyProperties(userUpsertDTO, u, CopyOptions.create().ignoreNullValue());
        int i = baseMapper.updateById(u);
        if (i <= 0) {
            throw new BizException(StrUtil.format("更新用户 {} 失败!", u.getName()));
        }
    }

    @Override
    public void deleteById(Long id) {
        long count = this.count(new LambdaQueryWrapper<UserEntity>().eq(UserEntity::getId, id));
        if (count <= 0) {
            throw new BizException("用户不存在!");
        }
        boolean b = this.removeById(id);
        if (!b) {
            throw new BizException("用户删除失败!");
        }
    }

    @Override
    public void updateStatus(Long id, Integer status) {
        long count = this.count(new LambdaQueryWrapper<UserEntity>().eq(UserEntity::getId, id));
        if (count <= 0) {
            throw new BizException("用户不存在!");
        }
        boolean update = lambdaUpdate()
                .set(UserEntity::getStatus, status)
                .eq(UserEntity::getId, id)
                .update();
        if (!update) {
            throw new BizException("用户状态更新失败!");
        }
    }

    @Override
    public void updateStatus(String account, Integer status) {
        UserEntity user = lambdaQuery().eq(UserEntity::getAccount, account).one();
        if (ObjectUtil.isNull(user)) {
            throw new BizException("用户不存在!");
        }

        user.setStatus(status);
        boolean update = this.updateById(user);
        if (!update) {
            throw new BizException("用户状态更新失败!");
        }
    }

    @Override
    public String queryAllUsername() {
        List<UserEntity> list = lambdaQuery()
                .select(UserEntity::getName, UserEntity::getAccount, UserEntity::getRole)
                .orderByDesc(UserEntity::getRole)
                .orderByAsc(UserEntity::getId)
                .list();

        if (CollUtil.isEmpty(list)) {
            return StrUtil.EMPTY;
        }

        StringBuilder sb = new StringBuilder();
        list.forEach(u -> {
            String role = u.getRole().getDesc();

            sb.append(StrUtil.format("[{}]{} / {}", role, ObjectUtil.isEmpty(u.getName()) ? "未命名" : u.getName(), u.getAccount()));
            sb.append("\n");
        });

        return String.valueOf(sb);
    }
}
