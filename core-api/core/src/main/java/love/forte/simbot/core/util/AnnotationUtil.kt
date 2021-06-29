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

@file:JvmName("AnnotationUtilForKt")
package love.forte.simbot.core.util

import love.forte.common.utils.annotation.AnnotationUtil
import kotlin.reflect.KParameter


public inline fun <reified T : Annotation> KParameter.getAnnotation(): T? {
    for (annotation in annotations) {
        val jAnnotation = annotation.annotationClass.java
        if (jAnnotation is T) {
            return jAnnotation
        }

        val found = AnnotationUtil.getAnnotation(jAnnotation, T::class.java)
        if (found != null) {
            return found
        }
    }
    return null
}
