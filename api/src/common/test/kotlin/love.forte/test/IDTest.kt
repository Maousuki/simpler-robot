package love.forte.test

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import love.forte.simbot.ID
import kotlin.test.Test

@Serializable
data class User(
    // @Serializable(with = ID.LongID.PrimitiveSerialSerializer::class)
    @Contextual
    val id: ID,
    val age: Int,
)

/**
 *
 * @author ForteScarlet
 */
class IDTest {

    @Test
    fun idSerializerTest() {
        val user = User(1.2.ID, 24)

        println(user)

        val json = Json
        println(json.encodeToString(user))


    }


}