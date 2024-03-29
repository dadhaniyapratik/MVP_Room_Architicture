// Code generated by moshi-kotlin-codegen. Do not edit.
package com.vimeo.networking2

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import java.lang.NullPointerException
import kotlin.Boolean
import kotlin.String

class LiveChatJsonAdapter(moshi: Moshi) : JsonAdapter<LiveChat>() {
    private val options: JsonReader.Options = JsonReader.Options.of("room_id", "token", "user")

    private val nullableStringAdapter: JsonAdapter<String?> =
            moshi.adapter<String?>(String::class.java, kotlin.collections.emptySet(), "roomId")

    private val nullableUserAdapter: JsonAdapter<User?> =
            moshi.adapter<User?>(User::class.java, kotlin.collections.emptySet(), "user")

    override fun toString(): String = "GeneratedJsonAdapter(LiveChat)"

    override fun fromJson(reader: JsonReader): LiveChat {
        var roomId: String? = null
        var roomIdSet: Boolean = false
        var token: String? = null
        var tokenSet: Boolean = false
        var user: User? = null
        var userSet: Boolean = false
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 ->  {
                    roomId = nullableStringAdapter.fromJson(reader)
                    roomIdSet = true
                }
                1 ->  {
                    token = nullableStringAdapter.fromJson(reader)
                    tokenSet = true
                }
                2 ->  {
                    user = nullableUserAdapter.fromJson(reader)
                    userSet = true
                }
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = LiveChat()
        result = result.copy(
                roomId = if (roomIdSet) roomId else result.roomId,
                token = if (tokenSet) token else result.token,
                user = if (userSet) user else result.user)
        return result
    }

    override fun toJson(writer: JsonWriter, value: LiveChat?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("room_id")
        nullableStringAdapter.toJson(writer, value.roomId)
        writer.name("token")
        nullableStringAdapter.toJson(writer, value.token)
        writer.name("user")
        nullableUserAdapter.toJson(writer, value.user)
        writer.endObject()
    }
}
