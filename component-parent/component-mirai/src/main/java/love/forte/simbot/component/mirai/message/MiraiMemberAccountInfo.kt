/*
 * Copyright (c) 2020. ForteScarlet All rights reserved.
 * Project  parent
 * File     MiraiMemberAccountInfo.kt
 *
 * You can contact the author through the following channels:
 * github https://github.com/ForteScarlet
 * gitee  https://gitee.com/ForteScarlet
 * email  ForteScarlet@163.com
 * QQ     1149159218
 */

package love.forte.simbot.component.mirai.message

import love.forte.simbot.core.api.message.containers.AccountInfo
import net.mamoe.mirai.contact.Member

/**
 * 基于 mirai [Member] 的 [AccountInfo] 实现。
 */
public data class MiraiMemberAccountInfo(private val member: Member) : AccountInfo {
    /**
     * 账号
     */
    override val accountCode: String
        get() = member.id.toString()

    override val accountCodeNumber: Long
        get() = member.id

    /** 昵称。 */
    override val accountNickname: String
        get() = member.nick

    /** [accountNickname] */
    override val accountRemark: String
        get() = member.nameCard

    /**
     * 得到账号的头像地址. 一般来讲为`null`的可能性很小
     */
    override val accountAvatar: String
        get() = member.avatarUrl
}