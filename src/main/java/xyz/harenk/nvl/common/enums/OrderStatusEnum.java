package xyz.harenk.nvl.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum OrderStatusEnum {
    FAILURE(0, "失败"),
    SUCCESS(1, "成功"),
    ;

    @EnumValue
    @JsonValue
    private final Integer code;
    private final String desc;

    OrderStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static OrderStatusEnum of(Integer type) {
        return Arrays.stream(OrderStatusEnum.values())
                .filter(x -> x.getCode().equals(type))
                .findFirst()
                .orElse(null);
    }
}
