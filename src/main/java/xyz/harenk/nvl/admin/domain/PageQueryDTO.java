package xyz.harenk.nvl.admin.domain;

import lombok.Data;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-31 02:20
 */
@Data
public class PageQueryDTO {
    private Long page = 1L;
    private Long pageSize = 10L;
}
