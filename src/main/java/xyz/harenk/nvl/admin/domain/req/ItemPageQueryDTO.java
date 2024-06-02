package xyz.harenk.nvl.admin.domain.req;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xyz.harenk.nvl.admin.domain.PageQueryDTO;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-31 12:31
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ItemPageQueryDTO extends PageQueryDTO {
    private String name;
}
