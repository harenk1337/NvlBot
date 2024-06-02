package xyz.harenk.nvl.admin.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import xyz.harenk.nvl.admin.domain.PageResult;
import xyz.harenk.nvl.admin.domain.R;
import xyz.harenk.nvl.admin.domain.entity.UserEntity;
import xyz.harenk.nvl.admin.domain.req.UserPageQueryDTO;
import xyz.harenk.nvl.admin.domain.req.UserUpsertDTO;
import xyz.harenk.nvl.admin.service.IUserService;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-29 16:36
 */
@RestController
@RequestMapping("/api/user")
@Tag(name = "用户管理")
public class UserController {

    @Resource
    private IUserService userService;

    @PostMapping("/list")
    public R<PageResult<UserEntity>> pageQueryUser(@RequestBody UserPageQueryDTO pageQueryDTO) {
        PageResult<UserEntity> page = userService.pageQueryUser(pageQueryDTO);
        return R.ok(page);
    }

    @PostMapping
    public R upsert(@RequestBody UserUpsertDTO userUpsertDTO) {
        userService.upsert(userUpsertDTO);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return R.ok();
    }

    @PutMapping("/enable/{id}")
    public R enable(@PathVariable Long id) {
        userService.updateStatus(id, 1);
        return R.ok();
    }

    @PutMapping("/disable/{id}")
    public R disable(@PathVariable Long id) {
        userService.updateStatus(id, 0);
        return R.ok();
    }
}
