package xyz.harenk.nvl.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.harenk.nvl.admin.domain.PageResult;
import xyz.harenk.nvl.admin.domain.entity.OrderEntity;
import xyz.harenk.nvl.admin.domain.req.OrderPageQueryDTO;
import xyz.harenk.nvl.admin.domain.req.OrderUpsertDTO;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-29 17:40
 */
public interface IOrderService extends IService<OrderEntity> {
    PageResult<OrderEntity> pageQueryOrder(OrderPageQueryDTO pageQueryDTO);

    void upsert(OrderUpsertDTO upsertDTO);

    void deleteById(Long id);
}
