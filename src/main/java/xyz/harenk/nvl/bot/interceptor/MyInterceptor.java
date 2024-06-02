package xyz.harenk.nvl.bot.interceptor;

import cn.hutool.core.text.StrPool;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.core.BotMessageEventInterceptor;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.mikuac.shiro.dto.event.message.MessageEvent;
import com.mikuac.shiro.dto.event.message.PrivateMessageEvent;
import com.mikuac.shiro.exception.ShiroException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import xyz.harenk.nvl.bot.DataCache;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-06-01 01:51
 */
@Slf4j
@Component
public class MyInterceptor implements BotMessageEventInterceptor {

    private static final String ADD_USER_COMMAND = ".添加用户";
    private static final String ADMIN_ONLY_MESSAGE = "该功能仅管理员可用";

    @Override
    public boolean preHandle(Bot bot, MessageEvent event) throws ShiroException {
        String rawMessage = event.getRawMessage();
        if (rawMessage.startsWith(ADD_USER_COMMAND)) {
            return handleAddUserCommand(bot, event);
        } else if (rawMessage.startsWith(StrPool.DOT)) {
            return isUserAuthorized(event);
        }
        return true;
    }

    private boolean isUserAuthorized(MessageEvent event) {
        return DataCache.getUserAccountList().contains(event.getUserId().toString());
    }

    private boolean handleAddUserCommand(Bot bot, MessageEvent event) {
        if (!isUserAuthorized(event)) {
            return false;
        }
        if (!DataCache.getSuperUserList().contains(event.getUserId().toString())) {
            sendMessage(bot, event);
            return false;
        }
        return true;
    }

    private void sendMessage(Bot bot, MessageEvent event) {
        if (event instanceof PrivateMessageEvent privateMessageEvent) {
            bot.sendPrivateMsg(privateMessageEvent.getUserId(), ADMIN_ONLY_MESSAGE, true);
        } else if (event instanceof GroupMessageEvent groupMessageEvent) {
            bot.sendGroupMsg(groupMessageEvent.getGroupId(), ADMIN_ONLY_MESSAGE, true);
        }
    }

    @Override
    public void afterCompletion(Bot bot, MessageEvent event) throws ShiroException {
        log.info("拦截器已放行");
    }
}
