package xyz.harenk.nvl.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.harenk.nvl.admin.domain.PageResult;
import xyz.harenk.nvl.admin.domain.entity.ItemEntity;
import xyz.harenk.nvl.admin.domain.req.ItemPageQueryDTO;
import xyz.harenk.nvl.admin.domain.req.ItemUpsertDTO;

import java.util.List;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-29 17:38
 */
public interface IItemService extends IService<ItemEntity> {
    PageResult<ItemEntity> pageQueryItem(ItemPageQueryDTO pageQueryDTO);

    void upsert(ItemUpsertDTO itemUpsertDTO);

    void deleteById(Long id);

    List<String> queryAllItemName();
}
