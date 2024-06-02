package xyz.harenk.nvl.admin.domain.req;

import lombok.Data;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-31 12:32
 */
@Data
public class ItemUpsertDTO {
    private Long id;
    private String name;
    private String code;
    private Integer apiId;
    private String apiKey;
}
