package xyz.harenk.nvl.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.harenk.nvl.admin.domain.PageResult;
import xyz.harenk.nvl.admin.domain.entity.UserEntity;
import xyz.harenk.nvl.admin.domain.req.UserPageQueryDTO;
import xyz.harenk.nvl.admin.domain.req.UserUpsertDTO;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-29 16:33
 */
public interface IUserService extends IService<UserEntity> {
    PageResult<UserEntity> pageQueryUser(UserPageQueryDTO pageQueryDTO);

    void upsert(UserUpsertDTO userUpsertDTO);

    void deleteById(Long id);

    void updateStatus(Long id, Integer status);

    void updateStatus(String account, Integer status);

    String queryAllUsername();

}
