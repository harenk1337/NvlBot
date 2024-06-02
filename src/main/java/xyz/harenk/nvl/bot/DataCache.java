package xyz.harenk.nvl.bot;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.core.CoreEvent;
import jakarta.annotation.Resource;
import lombok.Getter;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import xyz.harenk.nvl.admin.domain.entity.UserEntity;
import xyz.harenk.nvl.admin.mapper.UserMapper;
import xyz.harenk.nvl.common.enums.RoleEnum;

import java.util.Collections;
import java.util.List;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-06-01 04:34
 */
@Primary
@Component
public class DataCache extends CoreEvent {

    @Resource
    private UserMapper userMapper;

    @Getter
    private static List<String> userAccountList = Collections.emptyList();

    @Getter
    private static List<String> superUserList = Collections.emptyList();

    @Override
    public void online(Bot bot) {
//        bot.sendPrivateMsg(731113337, "我上线了~，正在初始化数据!", false);
        init();
    }


    @Scheduled(cron = "0/10 * * * * ?")
    public void init() {
        List<UserEntity> userEntities = userMapper.selectList(new LambdaQueryWrapper<UserEntity>()
                .select(UserEntity::getAccount, UserEntity::getRole)
                .eq(UserEntity::getStatus, 1));
        userAccountList = userEntities.stream().map(UserEntity::getAccount).toList();
        superUserList = userEntities.stream().filter(userEntity -> RoleEnum.ADMIN.equals(userEntity.getRole())).map(UserEntity::getAccount).toList();
    }

}
