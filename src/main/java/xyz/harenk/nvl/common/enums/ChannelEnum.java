package xyz.harenk.nvl.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-31 18:54
 */
@Getter
public enum ChannelEnum {
    ADMIN(0, "网页后台"),
    NORMAL(1, "手动绑定"),
    MARKET(2, "市场购买"),
    ;

    @EnumValue
    @JsonValue
    private final Integer type;
    private final String desc;

    ChannelEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static ChannelEnum of(Integer type){
        return Arrays.stream(ChannelEnum.values())
                .filter(x -> x.getType().equals(type))
                .findFirst()
                .orElse(null);
    }
}
