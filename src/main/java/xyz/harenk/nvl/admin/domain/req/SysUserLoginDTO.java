package xyz.harenk.nvl.admin.domain.req;

import lombok.Data;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-29 20:34
 */
@Data
public class SysUserLoginDTO {
    private String account;
    private String password;
}
