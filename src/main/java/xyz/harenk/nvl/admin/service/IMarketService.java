package xyz.harenk.nvl.admin.service;

import xyz.harenk.nvl.admin.domain.req.MarketItemPurchaseReqDTO;
import xyz.harenk.nvl.admin.domain.res.MarketResponse;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-31 18:31
 */
public interface IMarketService {
    void onPurchase(MarketItemPurchaseReqDTO dto);

    MarketResponse giveItem(String username, String itemName);
}
