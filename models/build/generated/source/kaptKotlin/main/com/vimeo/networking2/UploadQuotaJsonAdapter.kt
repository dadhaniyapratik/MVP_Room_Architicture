// Code generated by moshi-kotlin-codegen. Do not edit.
package com.vimeo.networking2

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import java.lang.NullPointerException
import kotlin.Boolean
import kotlin.String

class UploadQuotaJsonAdapter(moshi: Moshi) : JsonAdapter<UploadQuota>() {
    private val options: JsonReader.Options =
            JsonReader.Options.of("lifetime", "periodic", "quota", "space")

    private val nullableLifetimeAdapter: JsonAdapter<Lifetime?> =
            moshi.adapter<Lifetime?>(Lifetime::class.java, kotlin.collections.emptySet(), "lifetime")

    private val nullablePeriodicAdapter: JsonAdapter<Periodic?> =
            moshi.adapter<Periodic?>(Periodic::class.java, kotlin.collections.emptySet(), "periodic")

    private val nullableQuotaAdapter: JsonAdapter<Quota?> =
            moshi.adapter<Quota?>(Quota::class.java, kotlin.collections.emptySet(), "quota")

    private val nullableSpaceAdapter: JsonAdapter<Space?> =
            moshi.adapter<Space?>(Space::class.java, kotlin.collections.emptySet(), "space")

    override fun toString(): String = "GeneratedJsonAdapter(UploadQuota)"

    override fun fromJson(reader: JsonReader): UploadQuota {
        var lifetime: Lifetime? = null
        var lifetimeSet: Boolean = false
        var periodic: Periodic? = null
        var periodicSet: Boolean = false
        var quota: Quota? = null
        var quotaSet: Boolean = false
        var space: Space? = null
        var spaceSet: Boolean = false
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 ->  {
                    lifetime = nullableLifetimeAdapter.fromJson(reader)
                    lifetimeSet = true
                }
                1 ->  {
                    periodic = nullablePeriodicAdapter.fromJson(reader)
                    periodicSet = true
                }
                2 ->  {
                    quota = nullableQuotaAdapter.fromJson(reader)
                    quotaSet = true
                }
                3 ->  {
                    space = nullableSpaceAdapter.fromJson(reader)
                    spaceSet = true
                }
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = UploadQuota()
        result = result.copy(
                lifetime = if (lifetimeSet) lifetime else result.lifetime,
                periodic = if (periodicSet) periodic else result.periodic,
                quota = if (quotaSet) quota else result.quota,
                space = if (spaceSet) space else result.space)
        return result
    }

    override fun toJson(writer: JsonWriter, value: UploadQuota?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("lifetime")
        nullableLifetimeAdapter.toJson(writer, value.lifetime)
        writer.name("periodic")
        nullablePeriodicAdapter.toJson(writer, value.periodic)
        writer.name("quota")
        nullableQuotaAdapter.toJson(writer, value.quota)
        writer.name("space")
        nullableSpaceAdapter.toJson(writer, value.space)
        writer.endObject()
    }
}
