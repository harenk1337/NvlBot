package xyz.harenk.nvl.admin.domain.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-31 02:40
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpsertDTO {
    private Long id;
    private String name;
    private String account;
    private Integer role;
    private Integer status;
}
