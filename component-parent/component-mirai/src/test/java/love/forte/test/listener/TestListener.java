package love.forte.test.listener;

import love.forte.common.ioc.annotation.Beans;
import love.forte.simbot.annotation.*;
import love.forte.simbot.api.message.events.GroupMsg;
import love.forte.simbot.api.message.events.MessageGet;
import love.forte.simbot.api.message.events.MsgGet;
import love.forte.simbot.api.message.events.PrivateMsg;
import love.forte.simbot.api.sender.MsgSender;
import love.forte.simbot.constant.PriorityConstant;

@Beans
public class TestListener {


    @OnPrivate
    @Filter(codes = "1149159218")
    public void m1(MessageGet msg, MsgSender sender) {
        String getMsg = msg.getMsg();
        System.out.println(getMsg);
        sender.SENDER.sendPrivateMsg(msg, getMsg);
    }

    @OnGroup
    @Filter(groups = "703454734")
    public void m2(GroupMsg msg, MsgSender sender) {
        String getMsg = msg.getMsg();
        System.out.println(getMsg);
        sender.SENDER.sendGroupMsg(msg, getMsg);
    }

}
