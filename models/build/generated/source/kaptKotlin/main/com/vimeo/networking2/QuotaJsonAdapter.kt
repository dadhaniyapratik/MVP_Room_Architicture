// Code generated by moshi-kotlin-codegen. Do not edit.
package com.vimeo.networking2

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import java.lang.NullPointerException
import kotlin.Boolean
import kotlin.String

class QuotaJsonAdapter(moshi: Moshi) : JsonAdapter<Quota>() {
    private val options: JsonReader.Options = JsonReader.Options.of("hd", "sd")

    private val nullableBooleanAdapter: JsonAdapter<Boolean?> =
            moshi.adapter<Boolean?>(Boolean::class.javaObjectType, kotlin.collections.emptySet(), "hd")

    override fun toString(): String = "GeneratedJsonAdapter(Quota)"

    override fun fromJson(reader: JsonReader): Quota {
        var hd: Boolean? = null
        var hdSet: Boolean = false
        var sd: Boolean? = null
        var sdSet: Boolean = false
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 ->  {
                    hd = nullableBooleanAdapter.fromJson(reader)
                    hdSet = true
                }
                1 ->  {
                    sd = nullableBooleanAdapter.fromJson(reader)
                    sdSet = true
                }
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = Quota()
        result = result.copy(
                hd = if (hdSet) hd else result.hd,
                sd = if (sdSet) sd else result.sd)
        return result
    }

    override fun toJson(writer: JsonWriter, value: Quota?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("hd")
        nullableBooleanAdapter.toJson(writer, value.hd)
        writer.name("sd")
        nullableBooleanAdapter.toJson(writer, value.sd)
        writer.endObject()
    }
}
