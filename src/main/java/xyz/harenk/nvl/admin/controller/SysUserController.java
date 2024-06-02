package xyz.harenk.nvl.admin.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import xyz.harenk.nvl.admin.domain.R;
import xyz.harenk.nvl.admin.domain.req.SysUserAvatarDTO;
import xyz.harenk.nvl.admin.domain.req.SysUserLoginDTO;
import xyz.harenk.nvl.admin.domain.req.SysUserUpsertDTO;
import xyz.harenk.nvl.admin.domain.res.SysUserVO;
import xyz.harenk.nvl.admin.service.ISysUserService;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-29 20:32
 */
@RestController
@RequestMapping("/api/sys/user")
public class SysUserController {

    @Resource
    private ISysUserService sysUserService;

    @PostMapping("/login")
    public R<SysUserVO> login(@RequestBody SysUserLoginDTO sysUserLoginDTO) {
        SysUserVO sysUserVO = sysUserService.login(sysUserLoginDTO);
        return R.ok(sysUserVO);
    }

    @PostMapping("/logout")
    public R logout(String token) {
        sysUserService.logout(token);
        return R.ok();
    }

    @PutMapping("/reset")
    public R reset(@RequestBody SysUserUpsertDTO sysUserUpsertDTO) {
        sysUserService.reset(sysUserUpsertDTO);
        return R.ok();
    }

    @PostMapping("/avatar")
    public R<SysUserVO> avatar(@RequestBody SysUserAvatarDTO sysUserAvatarDTO) {
        SysUserVO vo = sysUserService.updateAvatar(sysUserAvatarDTO);
        return R.ok(vo);
    }
}
