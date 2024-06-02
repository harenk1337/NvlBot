package xyz.harenk.nvl.admin.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import xyz.harenk.nvl.admin.domain.PageResult;
import xyz.harenk.nvl.admin.domain.R;
import xyz.harenk.nvl.admin.domain.entity.OrderEntity;
import xyz.harenk.nvl.admin.domain.req.OrderPageQueryDTO;
import xyz.harenk.nvl.admin.domain.req.OrderUpsertDTO;
import xyz.harenk.nvl.admin.service.IOrderService;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-31 14:57
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Resource
    private IOrderService orderService;

    @PostMapping("/list")
    public R<PageResult<OrderEntity>> pageQueryOrder(@RequestBody OrderPageQueryDTO pageQueryDTO) {
        PageResult<OrderEntity> page = orderService.pageQueryOrder(pageQueryDTO);
        return R.ok(page);
    }

    @PostMapping
    public R upsert(@RequestBody OrderUpsertDTO upsertDTO) {
        orderService.upsert(upsertDTO);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable Long id) {
        orderService.deleteById(id);
        return R.ok();
    }
}
