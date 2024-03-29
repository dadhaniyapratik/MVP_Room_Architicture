// Code generated by moshi-kotlin-codegen. Do not edit.
package com.vimeo.networking2

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import java.lang.NullPointerException
import kotlin.Boolean
import kotlin.String

class GroupPrivacyJsonAdapter(moshi: Moshi) : JsonAdapter<GroupPrivacy>() {
    private val options: JsonReader.Options =
            JsonReader.Options.of("comment", "forums", "invite", "join", "videos", "videos")

    private val nullableStringAdapter: JsonAdapter<String?> =
            moshi.adapter<String?>(String::class.java, kotlin.collections.emptySet(), "commentPrivacy")

    override fun toString(): String = "GeneratedJsonAdapter(GroupPrivacy)"

    override fun fromJson(reader: JsonReader): GroupPrivacy {
        var commentPrivacy: String? = null
        var commentPrivacySet: Boolean = false
        var forumsPrivacy: String? = null
        var forumsPrivacySet: Boolean = false
        var invitePrivacy: String? = null
        var invitePrivacySet: Boolean = false
        var joinPrivacy: String? = null
        var joinPrivacySet: Boolean = false
        var videosPrivacy: String? = null
        var videosPrivacySet: Boolean = false
        var viewPrivacy: String? = null
        var viewPrivacySet: Boolean = false
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 ->  {
                    commentPrivacy = nullableStringAdapter.fromJson(reader)
                    commentPrivacySet = true
                }
                1 ->  {
                    forumsPrivacy = nullableStringAdapter.fromJson(reader)
                    forumsPrivacySet = true
                }
                2 ->  {
                    invitePrivacy = nullableStringAdapter.fromJson(reader)
                    invitePrivacySet = true
                }
                3 ->  {
                    joinPrivacy = nullableStringAdapter.fromJson(reader)
                    joinPrivacySet = true
                }
                4 ->  {
                    videosPrivacy = nullableStringAdapter.fromJson(reader)
                    videosPrivacySet = true
                }
                5 ->  {
                    viewPrivacy = nullableStringAdapter.fromJson(reader)
                    viewPrivacySet = true
                }
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = GroupPrivacy()
        result = result.copy(
                commentPrivacy = if (commentPrivacySet) commentPrivacy else result.commentPrivacy,
                forumsPrivacy = if (forumsPrivacySet) forumsPrivacy else result.forumsPrivacy,
                invitePrivacy = if (invitePrivacySet) invitePrivacy else result.invitePrivacy,
                joinPrivacy = if (joinPrivacySet) joinPrivacy else result.joinPrivacy,
                videosPrivacy = if (videosPrivacySet) videosPrivacy else result.videosPrivacy,
                viewPrivacy = if (viewPrivacySet) viewPrivacy else result.viewPrivacy)
        return result
    }

    override fun toJson(writer: JsonWriter, value: GroupPrivacy?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("comment")
        nullableStringAdapter.toJson(writer, value.commentPrivacy)
        writer.name("forums")
        nullableStringAdapter.toJson(writer, value.forumsPrivacy)
        writer.name("invite")
        nullableStringAdapter.toJson(writer, value.invitePrivacy)
        writer.name("join")
        nullableStringAdapter.toJson(writer, value.joinPrivacy)
        writer.name("videos")
        nullableStringAdapter.toJson(writer, value.videosPrivacy)
        writer.name("videos")
        nullableStringAdapter.toJson(writer, value.viewPrivacy)
        writer.endObject()
    }
}
