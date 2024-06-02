package xyz.harenk.nvl.admin.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.harenk.nvl.common.enums.ChannelEnum;
import xyz.harenk.nvl.common.enums.OrderStatusEnum;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-29 17:35
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_order")
public class OrderEntity {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 项目名
     */
    private String itemName;

    /**
     * 状态
     */
    private OrderStatusEnum status;

    /**
     * 详细信息
     */
    private String desc;

    /**
     * 绑定渠道
     */
    private ChannelEnum channel;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private String createTime;
}
