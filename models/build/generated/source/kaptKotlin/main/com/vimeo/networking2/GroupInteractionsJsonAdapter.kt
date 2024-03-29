// Code generated by moshi-kotlin-codegen. Do not edit.
package com.vimeo.networking2

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import java.lang.NullPointerException
import kotlin.Boolean
import kotlin.String

class GroupInteractionsJsonAdapter(moshi: Moshi) : JsonAdapter<GroupInteractions>() {
    private val options: JsonReader.Options = JsonReader.Options.of("join")

    private val nullableGroupFollowInteractionAdapter: JsonAdapter<GroupFollowInteraction?> =
            moshi.adapter<GroupFollowInteraction?>(GroupFollowInteraction::class.java, kotlin.collections.emptySet(), "follow")

    override fun toString(): String = "GeneratedJsonAdapter(GroupInteractions)"

    override fun fromJson(reader: JsonReader): GroupInteractions {
        var follow: GroupFollowInteraction? = null
        var followSet: Boolean = false
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 ->  {
                    follow = nullableGroupFollowInteractionAdapter.fromJson(reader)
                    followSet = true
                }
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = GroupInteractions()
        result = result.copy(
                follow = if (followSet) follow else result.follow)
        return result
    }

    override fun toJson(writer: JsonWriter, value: GroupInteractions?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("join")
        nullableGroupFollowInteractionAdapter.toJson(writer, value.follow)
        writer.endObject()
    }
}
