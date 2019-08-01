// Code generated by moshi-kotlin-codegen. Do not edit.
package com.vimeo.networking2

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.NullPointerException
import java.util.Date
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List

class CategoryJsonAdapter(moshi: Moshi) : JsonAdapter<Category>() {
    private val options: JsonReader.Options =
            JsonReader.Options.of("icon", "last_video_featured_time", "link", "metadata", "name", "parent", "pictures", "resource_key", "subcategories", "top_level", "uri")

    private val nullablePictureCollectionAdapter: JsonAdapter<PictureCollection?> =
            moshi.adapter<PictureCollection?>(PictureCollection::class.java, kotlin.collections.emptySet(), "icon")

    private val nullableDateAdapter: JsonAdapter<Date?> =
            moshi.adapter<Date?>(Date::class.java, kotlin.collections.emptySet(), "lastVideoFeaturedTime")

    private val nullableStringAdapter: JsonAdapter<String?> =
            moshi.adapter<String?>(String::class.java, kotlin.collections.emptySet(), "link")

    private val nullableMetadataOfCategoryConnectionsCategoryInteractionsAdapter: JsonAdapter<Metadata<CategoryConnections, CategoryInteractions>?> =
            moshi.adapter<Metadata<CategoryConnections, CategoryInteractions>?>(Types.newParameterizedType(Metadata::class.java, CategoryConnections::class.java, CategoryInteractions::class.java), kotlin.collections.emptySet(), "metadata")

    private val nullableCategoryAdapter: JsonAdapter<Category?> =
            moshi.adapter<Category?>(Category::class.java, kotlin.collections.emptySet(), "parent")

    private val nullableListOfCategoryAdapter: JsonAdapter<List<Category>?> =
            moshi.adapter<List<Category>?>(Types.newParameterizedType(List::class.java, Category::class.java), kotlin.collections.emptySet(), "subcategories")

    private val nullableBooleanAdapter: JsonAdapter<Boolean?> =
            moshi.adapter<Boolean?>(Boolean::class.javaObjectType, kotlin.collections.emptySet(), "topLevel")

    override fun toString(): String = "GeneratedJsonAdapter(Category)"

    override fun fromJson(reader: JsonReader): Category {
        var icon: PictureCollection? = null
        var iconSet: Boolean = false
        var lastVideoFeaturedTime: Date? = null
        var lastVideoFeaturedTimeSet: Boolean = false
        var link: String? = null
        var linkSet: Boolean = false
        var metadata: Metadata<CategoryConnections, CategoryInteractions>? = null
        var metadataSet: Boolean = false
        var name: String? = null
        var nameSet: Boolean = false
        var parent: Category? = null
        var parentSet: Boolean = false
        var pictures: PictureCollection? = null
        var picturesSet: Boolean = false
        var resourceKey: String? = null
        var resourceKeySet: Boolean = false
        var subcategories: List<Category>? = null
        var subcategoriesSet: Boolean = false
        var topLevel: Boolean? = null
        var topLevelSet: Boolean = false
        var uri: String? = null
        var uriSet: Boolean = false
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 ->  {
                    icon = nullablePictureCollectionAdapter.fromJson(reader)
                    iconSet = true
                }
                1 ->  {
                    lastVideoFeaturedTime = nullableDateAdapter.fromJson(reader)
                    lastVideoFeaturedTimeSet = true
                }
                2 ->  {
                    link = nullableStringAdapter.fromJson(reader)
                    linkSet = true
                }
                3 ->  {
                    metadata = nullableMetadataOfCategoryConnectionsCategoryInteractionsAdapter.fromJson(reader)
                    metadataSet = true
                }
                4 ->  {
                    name = nullableStringAdapter.fromJson(reader)
                    nameSet = true
                }
                5 ->  {
                    parent = nullableCategoryAdapter.fromJson(reader)
                    parentSet = true
                }
                6 ->  {
                    pictures = nullablePictureCollectionAdapter.fromJson(reader)
                    picturesSet = true
                }
                7 ->  {
                    resourceKey = nullableStringAdapter.fromJson(reader)
                    resourceKeySet = true
                }
                8 ->  {
                    subcategories = nullableListOfCategoryAdapter.fromJson(reader)
                    subcategoriesSet = true
                }
                9 ->  {
                    topLevel = nullableBooleanAdapter.fromJson(reader)
                    topLevelSet = true
                }
                10 ->  {
                    uri = nullableStringAdapter.fromJson(reader)
                    uriSet = true
                }
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = Category()
        result = result.copy(
                icon = if (iconSet) icon else result.icon,
                lastVideoFeaturedTime = if (lastVideoFeaturedTimeSet) lastVideoFeaturedTime else result.lastVideoFeaturedTime,
                link = if (linkSet) link else result.link,
                metadata = if (metadataSet) metadata else result.metadata,
                name = if (nameSet) name else result.name,
                parent = if (parentSet) parent else result.parent,
                pictures = if (picturesSet) pictures else result.pictures,
                resourceKey = if (resourceKeySet) resourceKey else result.resourceKey,
                subcategories = if (subcategoriesSet) subcategories else result.subcategories,
                topLevel = if (topLevelSet) topLevel else result.topLevel,
                uri = if (uriSet) uri else result.uri)
        return result
    }

    override fun toJson(writer: JsonWriter, value: Category?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("icon")
        nullablePictureCollectionAdapter.toJson(writer, value.icon)
        writer.name("last_video_featured_time")
        nullableDateAdapter.toJson(writer, value.lastVideoFeaturedTime)
        writer.name("link")
        nullableStringAdapter.toJson(writer, value.link)
        writer.name("metadata")
        nullableMetadataOfCategoryConnectionsCategoryInteractionsAdapter.toJson(writer, value.metadata)
        writer.name("name")
        nullableStringAdapter.toJson(writer, value.name)
        writer.name("parent")
        nullableCategoryAdapter.toJson(writer, value.parent)
        writer.name("pictures")
        nullablePictureCollectionAdapter.toJson(writer, value.pictures)
        writer.name("resource_key")
        nullableStringAdapter.toJson(writer, value.resourceKey)
        writer.name("subcategories")
        nullableListOfCategoryAdapter.toJson(writer, value.subcategories)
        writer.name("top_level")
        nullableBooleanAdapter.toJson(writer, value.topLevel)
        writer.name("uri")
        nullableStringAdapter.toJson(writer, value.uri)
        writer.endObject()
    }
}
