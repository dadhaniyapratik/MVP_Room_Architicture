// Code generated by moshi-kotlin-codegen. Do not edit.
package com.vimeo.networking2

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import java.lang.NullPointerException
import kotlin.Boolean
import kotlin.String

class LiveConfigurationJsonAdapter(moshi: Moshi) : JsonAdapter<LiveConfiguration>() {
    private val options: JsonReader.Options = JsonReader.Options.of("chat", "heartbeat")

    private val nullableLiveChatConfigurationAdapter: JsonAdapter<LiveChatConfiguration?> =
            moshi.adapter<LiveChatConfiguration?>(LiveChatConfiguration::class.java, kotlin.collections.emptySet(), "chat")

    private val nullableLiveHeartbeatConfigurationAdapter: JsonAdapter<LiveHeartbeatConfiguration?> =
            moshi.adapter<LiveHeartbeatConfiguration?>(LiveHeartbeatConfiguration::class.java, kotlin.collections.emptySet(), "heartbeat")

    override fun toString(): String = "GeneratedJsonAdapter(LiveConfiguration)"

    override fun fromJson(reader: JsonReader): LiveConfiguration {
        var chat: LiveChatConfiguration? = null
        var chatSet: Boolean = false
        var heartbeat: LiveHeartbeatConfiguration? = null
        var heartbeatSet: Boolean = false
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 ->  {
                    chat = nullableLiveChatConfigurationAdapter.fromJson(reader)
                    chatSet = true
                }
                1 ->  {
                    heartbeat = nullableLiveHeartbeatConfigurationAdapter.fromJson(reader)
                    heartbeatSet = true
                }
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = LiveConfiguration()
        result = result.copy(
                chat = if (chatSet) chat else result.chat,
                heartbeat = if (heartbeatSet) heartbeat else result.heartbeat)
        return result
    }

    override fun toJson(writer: JsonWriter, value: LiveConfiguration?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("chat")
        nullableLiveChatConfigurationAdapter.toJson(writer, value.chat)
        writer.name("heartbeat")
        nullableLiveHeartbeatConfigurationAdapter.toJson(writer, value.heartbeat)
        writer.endObject()
    }
}
