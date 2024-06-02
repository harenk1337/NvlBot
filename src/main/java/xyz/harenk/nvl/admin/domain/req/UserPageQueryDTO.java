package xyz.harenk.nvl.admin.domain.req;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xyz.harenk.nvl.admin.domain.PageQueryDTO;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-31 02:23
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserPageQueryDTO extends PageQueryDTO {
    private String name;
    private String account;
    private String role;
}
