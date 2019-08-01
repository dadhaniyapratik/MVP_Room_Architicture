// Code generated by moshi-kotlin-codegen. Do not edit.
package com.vimeo.networking2

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import java.lang.NullPointerException
import java.util.Date
import kotlin.Boolean
import kotlin.String

class LiveJsonAdapter(moshi: Moshi) : JsonAdapter<Live>() {
    private val options: JsonReader.Options =
            JsonReader.Options.of("active_time", "archived_time", "chat", "ended_time", "key", "link", "scheduled_start_time", "seconds_remaining", "status", "streaming_error")

    private val nullableDateAdapter: JsonAdapter<Date?> =
            moshi.adapter<Date?>(Date::class.java, kotlin.collections.emptySet(), "activeTime")

    private val nullableLiveChatAdapter: JsonAdapter<LiveChat?> =
            moshi.adapter<LiveChat?>(LiveChat::class.java, kotlin.collections.emptySet(), "chat")

    private val nullableStringAdapter: JsonAdapter<String?> =
            moshi.adapter<String?>(String::class.java, kotlin.collections.emptySet(), "key")

    private val nullableApiErrorAdapter: JsonAdapter<ApiError?> =
            moshi.adapter<ApiError?>(ApiError::class.java, kotlin.collections.emptySet(), "streamingError")

    override fun toString(): String = "GeneratedJsonAdapter(Live)"

    override fun fromJson(reader: JsonReader): Live {
        var activeTime: Date? = null
        var activeTimeSet: Boolean = false
        var archivedTime: Date? = null
        var archivedTimeSet: Boolean = false
        var chat: LiveChat? = null
        var chatSet: Boolean = false
        var endedTime: Date? = null
        var endedTimeSet: Boolean = false
        var key: String? = null
        var keySet: Boolean = false
        var link: String? = null
        var linkSet: Boolean = false
        var scheduledStartTime: Date? = null
        var scheduledStartTimeSet: Boolean = false
        var secondsRemaining: Date? = null
        var secondsRemainingSet: Boolean = false
        var liveStatus: String? = null
        var liveStatusSet: Boolean = false
        var streamingError: ApiError? = null
        var streamingErrorSet: Boolean = false
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 ->  {
                    activeTime = nullableDateAdapter.fromJson(reader)
                    activeTimeSet = true
                }
                1 ->  {
                    archivedTime = nullableDateAdapter.fromJson(reader)
                    archivedTimeSet = true
                }
                2 ->  {
                    chat = nullableLiveChatAdapter.fromJson(reader)
                    chatSet = true
                }
                3 ->  {
                    endedTime = nullableDateAdapter.fromJson(reader)
                    endedTimeSet = true
                }
                4 ->  {
                    key = nullableStringAdapter.fromJson(reader)
                    keySet = true
                }
                5 ->  {
                    link = nullableStringAdapter.fromJson(reader)
                    linkSet = true
                }
                6 ->  {
                    scheduledStartTime = nullableDateAdapter.fromJson(reader)
                    scheduledStartTimeSet = true
                }
                7 ->  {
                    secondsRemaining = nullableDateAdapter.fromJson(reader)
                    secondsRemainingSet = true
                }
                8 ->  {
                    liveStatus = nullableStringAdapter.fromJson(reader)
                    liveStatusSet = true
                }
                9 ->  {
                    streamingError = nullableApiErrorAdapter.fromJson(reader)
                    streamingErrorSet = true
                }
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = Live()
        result = result.copy(
                activeTime = if (activeTimeSet) activeTime else result.activeTime,
                archivedTime = if (archivedTimeSet) archivedTime else result.archivedTime,
                chat = if (chatSet) chat else result.chat,
                endedTime = if (endedTimeSet) endedTime else result.endedTime,
                key = if (keySet) key else result.key,
                link = if (linkSet) link else result.link,
                scheduledStartTime = if (scheduledStartTimeSet) scheduledStartTime else result.scheduledStartTime,
                secondsRemaining = if (secondsRemainingSet) secondsRemaining else result.secondsRemaining,
                liveStatus = if (liveStatusSet) liveStatus else result.liveStatus,
                streamingError = if (streamingErrorSet) streamingError else result.streamingError)
        return result
    }

    override fun toJson(writer: JsonWriter, value: Live?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("active_time")
        nullableDateAdapter.toJson(writer, value.activeTime)
        writer.name("archived_time")
        nullableDateAdapter.toJson(writer, value.archivedTime)
        writer.name("chat")
        nullableLiveChatAdapter.toJson(writer, value.chat)
        writer.name("ended_time")
        nullableDateAdapter.toJson(writer, value.endedTime)
        writer.name("key")
        nullableStringAdapter.toJson(writer, value.key)
        writer.name("link")
        nullableStringAdapter.toJson(writer, value.link)
        writer.name("scheduled_start_time")
        nullableDateAdapter.toJson(writer, value.scheduledStartTime)
        writer.name("seconds_remaining")
        nullableDateAdapter.toJson(writer, value.secondsRemaining)
        writer.name("status")
        nullableStringAdapter.toJson(writer, value.liveStatus)
        writer.name("streaming_error")
        nullableApiErrorAdapter.toJson(writer, value.streamingError)
        writer.endObject()
    }
}
