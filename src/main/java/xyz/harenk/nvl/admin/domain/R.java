package xyz.harenk.nvl.admin.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-29 17:42
 */
@Data
@Accessors(chain = true)
public class R<T> {

    private Integer code;
    private String message;
    private T data;
    private Long timestamp;

    public R() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> R<T> ok() {
        return new R<T>()
                .setCode(200)
                .setMessage("请求成功!");
    }

    public static <T> R<T> ok(T data) {
        return new R<T>()
                .setCode(200)
                .setMessage("请求成功!")
                .setData(data);
    }

    public static <T> R<T> fail() {
        return new R<T>()
                .setCode(201)
                .setMessage("请求失败，未知错误!");
    }

    public static <T> R<T> fail(String msg) {
        return new R<T>()
                .setCode(201)
                .setMessage(msg)
                .setData(null);
    }

    public static <T> R<T> fail(Integer code, String msg) {
        return new R<T>()
                .setCode(code)
                .setMessage(msg)
                .setData(null);
    }
}
