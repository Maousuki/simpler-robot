/*
 * Copyright (c) 2020. ForteScarlet All rights reserved.
 * Project  parent
 * File     Neko.kt
 *
 * You can contact the author through the following channels:
 * github https://github.com/ForteScarlet
 * gitee  https://gitee.com/ForteScarlet
 * email  ForteScarlet@163.com
 * QQ     1149159218
 */

@file:Suppress("unused")
@file:JvmName("CatSymbolConstant")

package love.forte.catcode

import love.forte.catcode.codes.Nyanko
import love.forte.catcode.codes.MapNeko


public const val CAT_HEAD = "[CAT:"
public const val CAT_END = "]"
public const val CAT_SPLIT = ","
public const val CAT_KV = "="


/**
 * 定义一个不可变的 Neko码 标准接口
 * - KQCode实例应当实现[Map]接口，使其可以作为一个**不可变**Map使用。
 * - KQCode实例应当实现[CharSequence]接口，其可以作为一个字符序列以得到猫猫码字符串
 *
 * 其参数是不可变的，如果需要一个可变参数的实例，参考方法[mutable]与其返回的接口类型[MutableNeko]
 * 如果想要获得一个纯空参的实例，参考[EmptyNeko]
 *
 * 建议子类通过私有构造+ 静态/伴生对象 方法来获取实例，例如 [MapNeko.byCode] [Nyanko.byCode]
 * 而不是直接通过构造方法。
 *
 * @since 1.8.0
 */
interface Neko: Map<String, String>, CharSequence {
    /**
     * 获取Code的类型。例如`at`
     */
    val type: String

    /**
     * 获取转义前的值。一般普通的[get]方法得到的是反转义后的。
     * 此处为保留原本的值不做转义。
     */
    fun getNoDecode(key: String): String?

    /**
     * 与其他字符序列拼接为[Msgs]实例
     */
    operator fun plus(other: CharSequence): Msgs = Msgs(collection = listOf(this, other))

    /**
     * 转化为可变参的[MutableNeko]
     */
    fun mutable(): MutableNeko

    /**
     * 转化为不可变类型[Neko]
     */
    fun immutable(): Neko


    companion object Of {

        /**
         * 得到一个空参的[Neko]实例。
         */
        @JvmStatic
        fun ofType(type: String): Neko = EmptyNeko(type)

        /**
         * 通过猫猫码字符串得到一个[Neko]实例
         */
        @JvmStatic
        fun of(code: String): Neko = Nyanko.byCode(code)

        /**
         * 从猫猫码字符串转到KQCode
         *
         * 1.8.0开始默认使用[Nyanko]作为静态工厂方法的[Neko]实例载体。
         * [Nyanko]是以字符串操作为基础的，因此不需要进行额外的转义。
         *
         * @since 1.1-1.11
         * @since 1.8.0
         * @param text 猫猫码字符串的正文
         * @param decode 因为这段猫猫码字符串可能已经转义过了，此处是否指定其转化的时候解码一次。默认为true
         */
        @JvmStatic
        @Deprecated("just use of(text)", ReplaceWith("FastKQCode(text)", "com.simplerobot.modules.utils.FastKQCode"))
        fun of(text: String, decode: Boolean = true): Neko {
            return Nyanko.byCode(text)
        }
    }


}

/**
 * 定义一个可变的KQCode标准接口
 * - MutableKQCode实例应当实现[MutableMap]接口，使其可以作为一个 **可变** Map使用。
 */
interface MutableNeko: Neko, MutableMap<String, String> {
    /**
     * type 也是可变类型
     */
    override var type: String
}



/**
 * 一个纯空参的[Neko]实例。
 *
 * 此类只有**不可变**状态, 并且应当为无参[Neko]的优先使用类。由于没有参数，因此不存在任何多余的计算与转义。
 *
 * 由于不存在对应的**可变状态**,
 * 因此[mutable]所得到的实例为[com.simplerobot.modules.utils.codes.MutableMapKQCode]实例。
 *
 */
data class EmptyNeko(override val type: String): Neko {

    private val codeText = "$CAT_HEAD$type$CAT_END"

    override fun toString(): String = codeText

    /**
     * 转化为可变参的[MutableNeko]
     */
    override fun mutable(): MutableNeko = MapNeko.mutableByCode(codeText)

    /**
     * 转化为不可变类型[Neko]
     */
    override fun immutable(): Neko = this
    override val entries: Set<Map.Entry<String, String>> = emptySet()
    override val keys: Set<String> = emptySet()
    override val size: Int = 0
    override val values: Collection<String> = emptyList()
    override fun containsKey(key: String): Boolean = false
    override fun containsValue(value: String): Boolean = false
    override operator fun get(key: String): String? = null
    override fun getNoDecode(key: String): String? = null
    override val length: Int = codeText.length
    override operator fun get(index: Int): Char = codeText[index]
    override fun isEmpty(): Boolean = true
    override fun subSequence(startIndex: Int, endIndex: Int): CharSequence = codeText.subSequence(startIndex, endIndex)
}







//**************************************
//*           for DSL
//**************************************



