package xyz.harenk.nvl.admin.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.harenk.nvl.common.enums.RoleEnum;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-29 16:31
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_user")
public class UserEntity {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户qq
     */
    private String account;

    /**
     * 用户角色
     */
    private RoleEnum role;

    /**
     * 用户状态
     */
    private Integer status;
}
