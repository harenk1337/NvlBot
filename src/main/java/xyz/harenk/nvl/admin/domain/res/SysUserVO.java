package xyz.harenk.nvl.admin.domain.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-29 20:34
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUserVO {
    private Long id;
    private String account;
    private String avatarUrl;
    private String token;
}
