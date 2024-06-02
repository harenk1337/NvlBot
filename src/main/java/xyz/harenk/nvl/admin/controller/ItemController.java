package xyz.harenk.nvl.admin.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import xyz.harenk.nvl.admin.domain.PageResult;
import xyz.harenk.nvl.admin.domain.R;
import xyz.harenk.nvl.admin.domain.entity.ItemEntity;
import xyz.harenk.nvl.admin.domain.req.ItemPageQueryDTO;
import xyz.harenk.nvl.admin.domain.req.ItemUpsertDTO;
import xyz.harenk.nvl.admin.service.IItemService;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-31 12:23
 */
@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Resource
    private IItemService itemService;

    @PostMapping("/list")
    public R<PageResult<ItemEntity>> pageQueryItem(@RequestBody ItemPageQueryDTO pageQueryDTO) {
        PageResult<ItemEntity> page = itemService.pageQueryItem(pageQueryDTO);
        return R.ok(page);
    }

    @PostMapping
    public R upsert(@RequestBody ItemUpsertDTO itemUpsertDTO) {
        itemService.upsert(itemUpsertDTO);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable Long id) {
        itemService.deleteById(id);
        return R.ok();
    }
}
