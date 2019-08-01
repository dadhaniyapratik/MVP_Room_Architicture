// Code generated by moshi-kotlin-codegen. Do not edit.
package com.vimeo.networking2

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.NullPointerException
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List

class FacebookConfigurationJsonAdapter(moshi: Moshi) : JsonAdapter<FacebookConfiguration>() {
    private val options: JsonReader.Options = JsonReader.Options.of("required_scopes")

    private val nullableListOfStringAdapter: JsonAdapter<List<String>?> =
            moshi.adapter<List<String>?>(Types.newParameterizedType(List::class.java, String::class.java), kotlin.collections.emptySet(), "requiredScopes")

    override fun toString(): String = "GeneratedJsonAdapter(FacebookConfiguration)"

    override fun fromJson(reader: JsonReader): FacebookConfiguration {
        var requiredScopes: List<String>? = null
        var requiredScopesSet: Boolean = false
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 ->  {
                    requiredScopes = nullableListOfStringAdapter.fromJson(reader)
                    requiredScopesSet = true
                }
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = FacebookConfiguration()
        result = result.copy(
                requiredScopes = if (requiredScopesSet) requiredScopes else result.requiredScopes)
        return result
    }

    override fun toJson(writer: JsonWriter, value: FacebookConfiguration?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("required_scopes")
        nullableListOfStringAdapter.toJson(writer, value.requiredScopes)
        writer.endObject()
    }
}
