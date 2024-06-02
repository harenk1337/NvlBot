package xyz.harenk.nvl.admin.domain.req;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xyz.harenk.nvl.admin.domain.PageQueryDTO;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-31 14:58
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderPageQueryDTO extends PageQueryDTO {
    private String userName;
    private String itemName;
    private String createBy;
    private Integer status;
}
