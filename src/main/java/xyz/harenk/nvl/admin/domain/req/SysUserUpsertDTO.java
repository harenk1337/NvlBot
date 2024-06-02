package xyz.harenk.nvl.admin.domain.req;

import lombok.Data;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-30 22:47
 */
@Data
public class SysUserUpsertDTO {
    private String account;
    private String oldPassword;
    private String newPassword;
}
