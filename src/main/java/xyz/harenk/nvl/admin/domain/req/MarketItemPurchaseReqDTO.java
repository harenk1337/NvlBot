package xyz.harenk.nvl.admin.domain.req;

import lombok.Data;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-31 18:32
 */
@Data
public class MarketItemPurchaseReqDTO {
    private String kind;
    private Double amount;
    private String username;
    private Long uniqueId;
    private String itemId;
    private String signature;
}
