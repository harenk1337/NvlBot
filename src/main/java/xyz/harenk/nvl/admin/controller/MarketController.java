package xyz.harenk.nvl.admin.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.harenk.nvl.admin.domain.req.MarketItemPurchaseReqDTO;
import xyz.harenk.nvl.admin.service.IMarketService;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-31 18:31
 */
@RestController
@RequestMapping("/api/market")
public class MarketController {

    @Resource
    private IMarketService marketService;

    @PostMapping("/purchase")
    public void onPurchase(MarketItemPurchaseReqDTO dto) {
        marketService.onPurchase(dto);
    }
}
