package xyz.harenk.nvl.common.exceptions.handler;

import cn.dev33.satoken.exception.NotLoginException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.harenk.nvl.admin.domain.R;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-29 17:46
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({NotLoginException.class})
    public ResponseEntity<R<String>> unauthorized(NotLoginException e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(R.fail(401, "未登录，无权访问!"));
    }

    @ExceptionHandler(RuntimeException.class)
    public R<String> exception(Exception e) {
        log.error("系统异常:{}", e.getMessage(), e);
        return R.fail(e.getMessage());
    }
}
