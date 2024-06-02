package xyz.harenk.nvl.admin.service.impl;

import cn.hutool.core.util.BooleanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import xyz.harenk.nvl.admin.domain.entity.ItemEntity;
import xyz.harenk.nvl.admin.domain.entity.OrderEntity;
import xyz.harenk.nvl.admin.domain.req.MarketItemPurchaseReqDTO;
import xyz.harenk.nvl.admin.domain.req.MarketItemReqDTO;
import xyz.harenk.nvl.admin.domain.res.MarketResponse;
import xyz.harenk.nvl.admin.mapper.ItemMapper;
import xyz.harenk.nvl.admin.mapper.OrderMapper;
import xyz.harenk.nvl.admin.service.IMarketService;
import xyz.harenk.nvl.common.enums.ChannelEnum;
import xyz.harenk.nvl.common.enums.OrderStatusEnum;
import xyz.harenk.nvl.common.exceptions.BizException;
import xyz.harenk.nvl.common.utils.MarketUtils;

import java.util.Optional;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-31 18:31
 */
@Service
public class MarketServiceImpl implements IMarketService {

    @Resource
    private ItemMapper itemMapper;

    @Resource
    private OrderMapper orderMapper;

    @Override
    public void onPurchase(MarketItemPurchaseReqDTO dto) {
        ItemEntity itemEntity = Optional.ofNullable(itemMapper.selectOne(new LambdaQueryWrapper<ItemEntity>()
                        .eq(ItemEntity::getCode, dto.getItemId())))
                .orElseThrow(() -> new BizException("未找到该项目，请检查！"));

        if (BooleanUtil.isFalse(MarketUtils.checkSign(dto, itemEntity.getApiKey()))) {
            throw new BizException("签名验证失败！");
        }

        OrderEntity order = OrderEntity.builder()
                .userName(dto.getUsername())
                .itemName(itemEntity.getName())
                .status(OrderStatusEnum.SUCCESS)
                .channel(ChannelEnum.MARKET)
                .createTime(String.valueOf(System.currentTimeMillis()))
                .build();

        int insert = orderMapper.insert(order);
        if (insert <= 0) {
            throw new BizException("订单创建失败！");
        }

    }

    @Override
    public MarketResponse giveItem(String username, String itemName) {
        ItemEntity itemEntity = Optional.ofNullable(itemMapper.selectOne(new LambdaQueryWrapper<ItemEntity>().eq(ItemEntity::getName, itemName)))
                .orElseThrow(() -> new BizException("未找到该项目，请检查！"));

        MarketItemReqDTO reqDTO = MarketItemReqDTO.builder()
                .id(String.valueOf(System.currentTimeMillis()))
                .userId(itemEntity.getApiId().longValue())
                .username(username)
                .code(itemEntity.getCode())
                .build();

        String sign = MarketUtils.generateSign(reqDTO, itemEntity.getApiKey());
        reqDTO.setSignature(sign);
        return MarketUtils.pushRequest(reqDTO);
    }
}
