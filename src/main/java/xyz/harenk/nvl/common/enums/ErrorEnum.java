package xyz.harenk.nvl.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-29 17:55
 */
@Getter
@AllArgsConstructor
public enum ErrorEnum {

    ALREADY_HAS_ITEM("This user already has this item.", "用户已拥有该项目！"),
    USER_DOESNT_EXIST("User doesn't exist.", "用户不存在！"),
    INVALID_KEY("Invalid key.", "API ID设置错误,请检查参数！"),
    SIGNATURE_ERROR("signature error", "API KEY设置错误,请检查参数！"),
    ITEM_ERROR("item error(must be approved, paid and public)", "项目错误,必须已通过且设置为付费与公开(Public)."),
    INVALID_ITEM("invalid item", "项目代码设置错误,请检查参数！"),
    INVALID_SIGN("invalid signature", "签名错误，请检查参数！");

    final String value;
    final String description;

    public static String of(String error) {
        return Objects.requireNonNull(Arrays.stream(ErrorEnum.values())
                        .filter(e -> e.getValue().equals(error))
                        .findFirst()
                        .orElse(null))
                .getDescription();
    }
}
