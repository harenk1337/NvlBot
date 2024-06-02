package xyz.harenk.nvl.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-06-01 21:05
 */
@Getter
public enum RoleEnum {
    USER(0, "普通用户"),
    ADMIN(1, "超级管理");

    @EnumValue
    @JsonValue
    private final Integer type;
    private final String desc;

    RoleEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static RoleEnum of(Integer type) {
        return Arrays.stream(RoleEnum.values())
                .filter(x -> x.getType().equals(type))
                .findFirst()
                .orElse(null);
    }
}
