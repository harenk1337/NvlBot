package xyz.harenk.nvl.admin.domain.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.harenk.nvl.common.enums.ChannelEnum;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-31 15:01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderUpsertDTO {
    private Long id;
    private String userName;
    private String itemName;
    private Integer status;
    private ChannelEnum channel;
    private String desc;
    private String createBy;
    private String createTime;
}
