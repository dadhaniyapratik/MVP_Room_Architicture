// Code generated by moshi-kotlin-codegen. Do not edit.
package com.vimeo.networking2

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import java.lang.NullPointerException
import kotlin.Boolean
import kotlin.String

class EmailJsonAdapter(moshi: Moshi) : JsonAdapter<Email>() {
    private val options: JsonReader.Options = JsonReader.Options.of("email")

    private val nullableStringAdapter: JsonAdapter<String?> =
            moshi.adapter<String?>(String::class.java, kotlin.collections.emptySet(), "email")

    override fun toString(): String = "GeneratedJsonAdapter(Email)"

    override fun fromJson(reader: JsonReader): Email {
        var email: String? = null
        var emailSet: Boolean = false
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 ->  {
                    email = nullableStringAdapter.fromJson(reader)
                    emailSet = true
                }
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = Email()
        result = result.copy(
                email = if (emailSet) email else result.email)
        return result
    }

    override fun toJson(writer: JsonWriter, value: Email?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("email")
        nullableStringAdapter.toJson(writer, value.email)
        writer.endObject()
    }
}
