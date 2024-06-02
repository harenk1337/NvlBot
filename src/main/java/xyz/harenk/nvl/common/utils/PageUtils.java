package xyz.harenk.nvl.common.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import xyz.harenk.nvl.admin.domain.PageResult;

import java.util.Collections;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-31 02:26
 */
public class PageUtils {
    private PageUtils() {
    }

    public static <T> PageResult<T> toPage(Page<T> page) {
        return PageResult.<T>builder()
                .page(page.getCurrent())
                .pageSize(page.getSize())
                .itemCount(page.getTotal())
                .pageCount(page.getPages())
                .records(page.getRecords())
                .build();
    }

    public static <T> PageResult<T> emptyPage() {
        return PageResult.<T>builder()
                .page(1L)
                .pageSize(10L)
                .itemCount(0L)
                .pageCount(1L)
                .records(Collections.emptyList())
                .build();
    }
}
