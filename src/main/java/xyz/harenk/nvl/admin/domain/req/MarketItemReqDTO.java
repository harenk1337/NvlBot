package xyz.harenk.nvl.admin.domain.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarketItemReqDTO {
    private String id;
    private Long userId;
    private String username;
    private String code;
    private String signature;
}
