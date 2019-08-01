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

class SearchFacetJsonAdapter(moshi: Moshi) : JsonAdapter<SearchFacet>() {
    private val options: JsonReader.Options = JsonReader.Options.of("name", "options")

    private val nullableStringAdapter: JsonAdapter<String?> =
            moshi.adapter<String?>(String::class.java, kotlin.collections.emptySet(), "name")

    private val nullableListOfFacetOptionAdapter: JsonAdapter<List<FacetOption>?> =
            moshi.adapter<List<FacetOption>?>(Types.newParameterizedType(List::class.java, FacetOption::class.java), kotlin.collections.emptySet(), "options")

    override fun toString(): String = "GeneratedJsonAdapter(SearchFacet)"

    override fun fromJson(reader: JsonReader): SearchFacet {
        var name: String? = null
        var nameSet: Boolean = false
        var options_: List<FacetOption>? = null
        var optionsSet: Boolean = false
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 ->  {
                    name = nullableStringAdapter.fromJson(reader)
                    nameSet = true
                }
                1 ->  {
                    options_ = nullableListOfFacetOptionAdapter.fromJson(reader)
                    optionsSet = true
                }
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = SearchFacet()
        result = result.copy(
                name = if (nameSet) name else result.name,
                options = if (optionsSet) options_ else result.options)
        return result
    }

    override fun toJson(writer: JsonWriter, value: SearchFacet?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("name")
        nullableStringAdapter.toJson(writer, value.name)
        writer.name("options")
        nullableListOfFacetOptionAdapter.toJson(writer, value.options)
        writer.endObject()
    }
}