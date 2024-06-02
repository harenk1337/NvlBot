package xyz.harenk.nvl.admin.domain.res;

import lombok.Data;

@Data
public class MarketResponse {
    private String itemCode;
    private Boolean succ;
    private Boolean success;
    private String error;
}
