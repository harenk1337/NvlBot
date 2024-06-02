package xyz.harenk.nvl.admin.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-29 17:34
 */
@Data
@TableName("t_item")
public class ItemEntity {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 项目名
     */
    private String name;

    /**
     * 项目代码
     */
    private String code;

    /**
     * api id
     */
    private Integer apiId;

    /**
     * api key
     */
    private String apiKey;
}
