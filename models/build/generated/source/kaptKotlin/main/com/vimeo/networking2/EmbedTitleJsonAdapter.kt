// Code generated by moshi-kotlin-codegen. Do not edit.
package com.vimeo.networking2

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import java.lang.NullPointerException
import kotlin.Boolean
import kotlin.String

class EmbedTitleJsonAdapter(moshi: Moshi) : JsonAdapter<EmbedTitle>() {
    private val options: JsonReader.Options = JsonReader.Options.of("name", "owner", "portrait")

    private val nullableStringAdapter: JsonAdapter<String?> =
            moshi.adapter<String?>(String::class.java, kotlin.collections.emptySet(), "name")

    override fun toString(): String = "GeneratedJsonAdapter(EmbedTitle)"

    override fun fromJson(reader: JsonReader): EmbedTitle {
        var name: String? = null
        var nameSet: Boolean = false
        var owner: String? = null
        var ownerSet: Boolean = false
        var portrait: String? = null
        var portraitSet: Boolean = false
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 ->  {
                    name = nullableStringAdapter.fromJson(reader)
                    nameSet = true
                }
                1 ->  {
                    owner = nullableStringAdapter.fromJson(reader)
                    ownerSet = true
                }
                2 ->  {
                    portrait = nullableStringAdapter.fromJson(reader)
                    portraitSet = true
                }
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = EmbedTitle()
        result = result.copy(
                name = if (nameSet) name else result.name,
                owner = if (ownerSet) owner else result.owner,
                portrait = if (portraitSet) portrait else result.portrait)
        return result
    }

    override fun toJson(writer: JsonWriter, value: EmbedTitle?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("name")
        nullableStringAdapter.toJson(writer, value.name)
        writer.name("owner")
        nullableStringAdapter.toJson(writer, value.owner)
        writer.name("portrait")
        nullableStringAdapter.toJson(writer, value.portrait)
        writer.endObject()
    }
}