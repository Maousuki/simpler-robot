/*
 *
 *  * Copyright (c) 2021. ForteScarlet All rights reserved.
 *  * Project  simple-robot
 *  * File     MiraiAvatar.kt
 *  *
 *  * You can contact the author through the following channels:
 *  * github https://github.com/ForteScarlet
 *  * gitee  https://gitee.com/ForteScarlet
 *  * email  ForteScarlet@163.com
 *  * QQ     1149159218
 *
 */

package love.forte.test;

import love.forte.common.configuration.Configuration;
import love.forte.simbot.annotation.SimbotApplication;
import love.forte.simbot.bot.Bot;
import love.forte.simbot.bot.BotManager;
import love.forte.simbot.core.SimbotApp;
import love.forte.simbot.core.SimbotContext;
import love.forte.simbot.core.SimbotProcess;
import org.jetbrains.annotations.NotNull;

/**
 * @author ForteScarlet
 */
@SimbotApplication
public class Test implements SimbotProcess {
    public static void main(String[] args) {
        // init();
        SimbotApp.run(Test.class, args);
    }

    private static void init() {
        // MiraiBotEventRegistrars.registerEventSolver(
        //         MessagePostSendEvent.class,
        //         TestPostEvent.class,
        //         bot -> true,
        //         (bot, e) -> new TestPostEvent(e)
        // );
    }


    @Override
    public void pre(@NotNull Configuration config) {

    }

    @Override
    public void post(SimbotContext context) {
        BotManager manager = context.getBotManager();
        //
        for (Bot bot : manager.getBots()) {
            bot.getSender().SENDER.sendPrivateMsg(1149159218, "我测试好了1");
            bot.getSender().SENDER.sendPrivateMsg(1149159218, "我测试好了2");
            bot.getSender().SENDER.sendPrivateMsg(1149159218, "我测试好了3");
            bot.getSender().SENDER.sendPrivateMsg(1149159218, "我测试好了4");
            bot.getSender().SENDER.sendPrivateMsg(1149159218, "我测试好了5");
            bot.getSender().SENDER.sendPrivateMsgAsync(1149159218, "我测试好了, async1");
            bot.getSender().SENDER.sendPrivateMsgAsync(1149159218, "我测试好了, async2");
            bot.getSender().SENDER.sendPrivateMsgAsync(1149159218, "我测试好了, async3");
            bot.getSender().SENDER.sendPrivateMsgAsync(1149159218, "我测试好了, async4");
            bot.getSender().SENDER.sendPrivateMsgAsync(1149159218, "我测试好了, async5");
        }


    }
}
