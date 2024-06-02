package xyz.harenk.nvl.bot.listener;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.mikuac.shiro.annotation.AnyMessageHandler;
import com.mikuac.shiro.annotation.MessageHandlerFilter;
import com.mikuac.shiro.annotation.common.Shiro;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.AnyMessageEvent;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import xyz.harenk.nvl.admin.domain.req.OrderUpsertDTO;
import xyz.harenk.nvl.admin.domain.req.UserUpsertDTO;
import xyz.harenk.nvl.admin.domain.res.MarketResponse;
import xyz.harenk.nvl.admin.service.IItemService;
import xyz.harenk.nvl.admin.service.IMarketService;
import xyz.harenk.nvl.admin.service.IOrderService;
import xyz.harenk.nvl.admin.service.IUserService;
import xyz.harenk.nvl.common.enums.ChannelEnum;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-31 21:56
 */
@Shiro
@Component
public class MyListener {

    @Resource
    private IUserService userService;

    @Resource
    private IItemService itemService;

    @Resource
    private IMarketService marketService;

    @Resource
    private IOrderService orderService;

    @AnyMessageHandler
    @MessageHandlerFilter(cmd = "^\\.菜单$")
    public void queryBinds(Bot bot, AnyMessageEvent event) {
        String menu = """
                以下所有命令以 .开头, 例如 .查用户
                1、菜单 -> 显示本菜单
                2、查用户 -> 查询所有可使用本 Bot 的用户
                3、查项目 -> 查询当前所有项目
                4、绑定 (NL 账号) (项目名) -> 推送项目给所输入的 NL 账号
                5、添加用户 (用户 QQ) [用户名:未命名] -> 给用户添加 Bot 使用权限
                6、启用/禁用 (用户 QQ) -> 启用/禁用 用户使用权限
                以上括号内的参数为必填，中括号为选填，冒号后面为不填的默认值
                """;
        bot.sendMsg(event, menu, false);
    }

    @AnyMessageHandler
    @MessageHandlerFilter(cmd = "^\\.查用户$")
    public void queryUsers(Bot bot, AnyMessageEvent event) {
        String userNames = userService.queryAllUsername();
        if (ObjectUtil.isEmpty(userNames)) {
            bot.sendMsg(event, "用户列表为空！", true);
            return;
        }
        bot.sendMsg(event, userNames, true);
    }


    @AnyMessageHandler
    @MessageHandlerFilter(cmd = "^\\.查项目$")
    public void queryItems(Bot bot, AnyMessageEvent event) {
        List<String> itemList = itemService.queryAllItemName();
        if (CollUtil.isEmpty(itemList)) {
            bot.sendMsg(event, "项目列表为空！", true);
            return;
        }

        AtomicInteger count = new AtomicInteger(1);
        StringBuilder sb = new StringBuilder();
        itemList.forEach(i -> sb.append(count.getAndIncrement()).append(".").append(i).append("\n"));

        bot.sendMsg(event, String.valueOf(sb), true);
    }

    @AnyMessageHandler
    @MessageHandlerFilter(cmd = "^\\.绑定\\s([^ ]+)\\s([^ ]+)$")
    public void giveItem(Bot bot, AnyMessageEvent event, Matcher matcher) {
        String itemName = matcher.group(1);
        String userName = matcher.group(2);
        Long userId = event.getUserId();

        try {
            MarketResponse response = marketService.giveItem(userName, itemName);
            new Thread(() -> saveOrder(userName, itemName, response, String.valueOf(userId)))
                    .start();

            String msg = buildMsg(response, userName, itemName);
            bot.sendMsg(event, String.valueOf(msg), true);
        } catch (Exception e) {
            bot.sendMsg(event, e.getMessage(), true);
        }
    }

    private void saveOrder(String userName, String itemName, MarketResponse response, String userId) {
        boolean success = BooleanUtil.isTrue(response.getSuccess());
        OrderUpsertDTO orderUpsertDTO = OrderUpsertDTO.builder()
                .userName(userName)
                .itemName(itemName)
                .status(success ? 1 : 0)
                .channel(ChannelEnum.NORMAL)
                .createBy(userId)
                .createTime(String.valueOf(System.currentTimeMillis()))
                .build();
        if (!success) {
            orderUpsertDTO.setDesc(response.getError());
        }
        orderService.upsert(orderUpsertDTO);
    }

    private String buildMsg(MarketResponse response, String userName, String itemName) {
        StringBuilder msg = new StringBuilder();
        if (BooleanUtil.isTrue(response.getSuccess())) {
            msg.append(StrUtil.format("绑定成功!\n用户名:{}\n项目:{}\n时间:{}", userName, itemName, DateUtil.now()));
        } else {
            msg.append(StrUtil.format("绑定失败!\n原因:{}\n时间:{}", response.getError(), DateUtil.now()));
        }
        return String.valueOf(msg);
    }

    @AnyMessageHandler
    @MessageHandlerFilter(cmd = "^\\.添加用户\\s([^ ]+)(?:\\s([^ ]+))?$")
    public void addUser(Bot bot, AnyMessageEvent event, Matcher matcher) {
        String account = matcher.group(1);
        String name = matcher.group(2);
        if (ObjectUtil.isEmpty(name)) {
            name = "未命名";
        }

        UserUpsertDTO upsertDTO = UserUpsertDTO.builder()
                .name(name)
                .account(account)
                .build();

        try {
            userService.upsert(upsertDTO);
            bot.sendMsg(event, String.valueOf(StrUtil.format("新增用户: {} - QQ: {}", name, account)), true);
        } catch (RuntimeException e) {
            bot.sendMsg(event, e.getMessage(), true);
        }
    }

    @AnyMessageHandler
    @MessageHandlerFilter(cmd = "^\\.([^ ]+)\\s([^ ]+)$")
    public void updateUser(Bot bot, AnyMessageEvent event, Matcher matcher) {
        String action = matcher.group(1);
        String account = matcher.group(2);
        if (ObjectUtil.notEqual(action, "启用") && ObjectUtil.notEqual(action, "禁用")) {
            return;
        }

        try {
            userService.updateStatus(account, ObjectUtil.equal(action, "启用") ? 1 : 0);
            bot.sendMsg(event, String.valueOf(StrUtil.format("成功{}用户: {}", action, account)), true);
        } catch (RuntimeException e) {
            bot.sendMsg(event, e.getMessage(), true);
        }
    }
}
