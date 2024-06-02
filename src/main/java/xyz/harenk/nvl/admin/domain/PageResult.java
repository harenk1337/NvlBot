package xyz.harenk.nvl.admin.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-31 02:20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {
    private Long page;
    private Long pageSize;
    private Long itemCount;
    private Long pageCount;
    private List<T> records;
}
