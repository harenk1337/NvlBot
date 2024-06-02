package xyz.harenk.nvl.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.harenk.nvl.admin.domain.PageResult;
import xyz.harenk.nvl.admin.domain.entity.OrderEntity;
import xyz.harenk.nvl.admin.domain.req.OrderPageQueryDTO;
import xyz.harenk.nvl.admin.domain.req.OrderUpsertDTO;
import xyz.harenk.nvl.admin.mapper.OrderMapper;
import xyz.harenk.nvl.admin.service.IOrderService;
import xyz.harenk.nvl.common.exceptions.BizException;
import xyz.harenk.nvl.common.utils.PageUtils;

import java.util.Optional;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-29 17:40
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements IOrderService {
    @Override
    public PageResult<OrderEntity> pageQueryOrder(OrderPageQueryDTO pageQueryDTO) {
        Page<OrderEntity> page = new Page<>(pageQueryDTO.getPage(), pageQueryDTO.getPageSize());
        LambdaQueryWrapper<OrderEntity> queryWrapper = Wrappers.<OrderEntity>lambdaQuery()
                .like(ObjectUtil.isNotEmpty(pageQueryDTO.getUserName()), OrderEntity::getUserName, pageQueryDTO.getUserName())
                .like(ObjectUtil.isNotEmpty(pageQueryDTO.getItemName()), OrderEntity::getItemName, pageQueryDTO.getItemName())
                .like(ObjectUtil.isNotEmpty(pageQueryDTO.getCreateBy()), OrderEntity::getCreateBy, pageQueryDTO.getCreateBy())
                .eq(ObjectUtil.isNotEmpty(pageQueryDTO.getStatus()), OrderEntity::getStatus, pageQueryDTO.getStatus())
                .orderByAsc(OrderEntity::getCreateTime);

        Page<OrderEntity> orderEntityPage = this.page(page, queryWrapper);
        return PageUtils.toPage(orderEntityPage);
    }

    @Override
    public void upsert(OrderUpsertDTO upsertDTO) {
        if (ObjectUtil.isNull(upsertDTO.getId())) {
            insertOrder(upsertDTO);
        } else {
            updateOrder(upsertDTO);
        }
    }

    private void insertOrder(OrderUpsertDTO upsertDTO) {
        OrderEntity order = BeanUtil.toBean(upsertDTO, OrderEntity.class, CopyOptions.create().ignoreNullValue());

        boolean save = this.save(order);
        if (!save) {
            throw new BizException("订单新增失败！");
        }
    }

    private void updateOrder(OrderUpsertDTO upsertDTO) {
        OrderEntity orderEntity = Optional.ofNullable(this.getById(upsertDTO.getId()))
                .orElseThrow(() -> new BizException("订单不存在！"));

        BeanUtil.copyProperties(upsertDTO, orderEntity);
        int i = baseMapper.updateById(orderEntity);
        if (i <= 0) {
            throw new BizException("订单更新失败！");
        }
    }

    @Override
    public void deleteById(Long id) {
        OrderEntity orderEntity = Optional.ofNullable(this.getById(id))
                .orElseThrow(() -> new BizException("订单不存在！"));

        boolean b = this.removeById(orderEntity);
        if (!b) {
            throw new BizException("订单删除失败！");
        }
    }
}
