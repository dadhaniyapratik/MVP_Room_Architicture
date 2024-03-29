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

class PlayJsonAdapter(moshi: Moshi) : JsonAdapter<Play>() {
    private val options: JsonReader.Options =
            JsonReader.Options.of("dash", "hls", "progress", "progressive", "source", "status")

    private val nullableVideoFileAdapter: JsonAdapter<VideoFile?> =
            moshi.adapter<VideoFile?>(VideoFile::class.java, kotlin.collections.emptySet(), "dash")

    private val nullablePlayProgressAdapter: JsonAdapter<PlayProgress?> =
            moshi.adapter<PlayProgress?>(PlayProgress::class.java, kotlin.collections.emptySet(), "progress")

    private val nullableListOfProgressiveVideoFileAdapter: JsonAdapter<List<ProgressiveVideoFile>?> =
            moshi.adapter<List<ProgressiveVideoFile>?>(Types.newParameterizedType(List::class.java, ProgressiveVideoFile::class.java), kotlin.collections.emptySet(), "progressive")

    private val nullableListOfVideoSourceFileAdapter: JsonAdapter<List<VideoSourceFile>?> =
            moshi.adapter<List<VideoSourceFile>?>(Types.newParameterizedType(List::class.java, VideoSourceFile::class.java), kotlin.collections.emptySet(), "source")

    private val nullableStringAdapter: JsonAdapter<String?> =
            moshi.adapter<String?>(String::class.java, kotlin.collections.emptySet(), "videoPlayStatus")

    override fun toString(): String = "GeneratedJsonAdapter(Play)"

    override fun fromJson(reader: JsonReader): Play {
        var dash: VideoFile? = null
        var dashSet: Boolean = false
        var hls: VideoFile? = null
        var hlsSet: Boolean = false
        var progress: PlayProgress? = null
        var progressSet: Boolean = false
        var progressive: List<ProgressiveVideoFile>? = null
        var progressiveSet: Boolean = false
        var source: List<VideoSourceFile>? = null
        var sourceSet: Boolean = false
        var videoPlayStatus: String? = null
        var videoPlayStatusSet: Boolean = false
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 ->  {
                    dash = nullableVideoFileAdapter.fromJson(reader)
                    dashSet = true
                }
                1 ->  {
                    hls = nullableVideoFileAdapter.fromJson(reader)
                    hlsSet = true
                }
                2 ->  {
                    progress = nullablePlayProgressAdapter.fromJson(reader)
                    progressSet = true
                }
                3 ->  {
                    progressive = nullableListOfProgressiveVideoFileAdapter.fromJson(reader)
                    progressiveSet = true
                }
                4 ->  {
                    source = nullableListOfVideoSourceFileAdapter.fromJson(reader)
                    sourceSet = true
                }
                5 ->  {
                    videoPlayStatus = nullableStringAdapter.fromJson(reader)
                    videoPlayStatusSet = true
                }
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = Play()
        result = result.copy(
                dash = if (dashSet) dash else result.dash,
                hls = if (hlsSet) hls else result.hls,
                progress = if (progressSet) progress else result.progress,
                progressive = if (progressiveSet) progressive else result.progressive,
                source = if (sourceSet) source else result.source,
                videoPlayStatus = if (videoPlayStatusSet) videoPlayStatus else result.videoPlayStatus)
        return result
    }

    override fun toJson(writer: JsonWriter, value: Play?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("dash")
        nullableVideoFileAdapter.toJson(writer, value.dash)
        writer.name("hls")
        nullableVideoFileAdapter.toJson(writer, value.hls)
        writer.name("progress")
        nullablePlayProgressAdapter.toJson(writer, value.progress)
        writer.name("progressive")
        nullableListOfProgressiveVideoFileAdapter.toJson(writer, value.progressive)
        writer.name("source")
        nullableListOfVideoSourceFileAdapter.toJson(writer, value.source)
        writer.name("status")
        nullableStringAdapter.toJson(writer, value.videoPlayStatus)
        writer.endObject()
    }
}
