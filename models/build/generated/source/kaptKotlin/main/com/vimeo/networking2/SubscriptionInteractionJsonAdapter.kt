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

class SubscriptionInteractionJsonAdapter(moshi: Moshi) : JsonAdapter<SubscriptionInteraction>() {
    private val options: JsonReader.Options =
            JsonReader.Options.of("drm", "expires_time", "purchase_time", "stream")

    private val nullableBooleanAdapter: JsonAdapter<Boolean?> =
            moshi.adapter<Boolean?>(Boolean::class.javaObjectType, kotlin.collections.emptySet(), "drm")

    private val nullableDateAdapter: JsonAdapter<Date?> =
            moshi.adapter<Date?>(Date::class.java, kotlin.collections.emptySet(), "expiresTime")

    private val nullableStringAdapter: JsonAdapter<String?> =
            moshi.adapter<String?>(String::class.java, kotlin.collections.emptySet(), "streamAccess")

    override fun toString(): String = "GeneratedJsonAdapter(SubscriptionInteraction)"

    override fun fromJson(reader: JsonReader): SubscriptionInteraction {
        var drm: Boolean? = null
        var drmSet: Boolean = false
        var expiresTime: Date? = null
        var expiresTimeSet: Boolean = false
        var purchaseTime: Date? = null
        var purchaseTimeSet: Boolean = false
        var streamAccess: String? = null
        var streamAccessSet: Boolean = false
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 ->  {
                    drm = nullableBooleanAdapter.fromJson(reader)
                    drmSet = true
                }
                1 ->  {
                    expiresTime = nullableDateAdapter.fromJson(reader)
                    expiresTimeSet = true
                }
                2 ->  {
                    purchaseTime = nullableDateAdapter.fromJson(reader)
                    purchaseTimeSet = true
                }
                3 ->  {
                    streamAccess = nullableStringAdapter.fromJson(reader)
                    streamAccessSet = true
                }
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = SubscriptionInteraction()
        result = result.copy(
                drm = if (drmSet) drm else result.drm,
                expiresTime = if (expiresTimeSet) expiresTime else result.expiresTime,
                purchaseTime = if (purchaseTimeSet) purchaseTime else result.purchaseTime,
                streamAccess = if (streamAccessSet) streamAccess else result.streamAccess)
        return result
    }

    override fun toJson(writer: JsonWriter, value: SubscriptionInteraction?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("drm")
        nullableBooleanAdapter.toJson(writer, value.drm)
        writer.name("expires_time")
        nullableDateAdapter.toJson(writer, value.expiresTime)
        writer.name("purchase_time")
        nullableDateAdapter.toJson(writer, value.purchaseTime)
        writer.name("stream")
        nullableStringAdapter.toJson(writer, value.streamAccess)
        writer.endObject()
    }
}
