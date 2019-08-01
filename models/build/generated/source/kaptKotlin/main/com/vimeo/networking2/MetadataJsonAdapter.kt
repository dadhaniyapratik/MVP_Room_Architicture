// Code generated by moshi-kotlin-codegen. Do not edit.
package com.vimeo.networking2

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import java.lang.NullPointerException
import java.lang.reflect.Type
import kotlin.Array
import kotlin.Boolean
import kotlin.String

class MetadataJsonAdapter<Connections_T, Interactions_T>(moshi: Moshi, types: Array<Type>) : JsonAdapter<Metadata<Connections_T, Interactions_T>>() {
    private val options: JsonReader.Options = JsonReader.Options.of("connections", "interactions")

    private val nullableConnections_TNullableAnyAdapter: JsonAdapter<Connections_T?> =
            moshi.adapter<Connections_T?>(types[0], kotlin.collections.emptySet(), "connections")

    private val nullableInteractions_TNullableAnyAdapter: JsonAdapter<Interactions_T?> =
            moshi.adapter<Interactions_T?>(types[1], kotlin.collections.emptySet(), "interactions")

    override fun toString(): String = "GeneratedJsonAdapter(Metadata)"

    override fun fromJson(reader: JsonReader): Metadata<Connections_T, Interactions_T> {
        var connections: Connections_T? = null
        var connectionsSet: Boolean = false
        var interactions: Interactions_T? = null
        var interactionsSet: Boolean = false
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 ->  {
                    connections = nullableConnections_TNullableAnyAdapter.fromJson(reader)
                    connectionsSet = true
                }
                1 ->  {
                    interactions = nullableInteractions_TNullableAnyAdapter.fromJson(reader)
                    interactionsSet = true
                }
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = Metadata<Connections_T, Interactions_T>()
        result = result.copy(
                connections = if (connectionsSet) connections else result.connections,
                interactions = if (interactionsSet) interactions else result.interactions)
        return result
    }

    override fun toJson(writer: JsonWriter, value: Metadata<Connections_T, Interactions_T>?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("connections")
        nullableConnections_TNullableAnyAdapter.toJson(writer, value.connections)
        writer.name("interactions")
        nullableInteractions_TNullableAnyAdapter.toJson(writer, value.interactions)
        writer.endObject()
    }
}