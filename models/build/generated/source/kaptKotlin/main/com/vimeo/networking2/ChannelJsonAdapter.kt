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

class ChannelJsonAdapter(moshi: Moshi) : JsonAdapter<Channel>() {
    private val options: JsonReader.Options =
            JsonReader.Options.of("categories", "created_time", "description", "header", "link", "metadata", "modified_time", "name", "pictures", "privacy", "resource_key", "tags", "uri", "user")

    private val nullableListOfCategoryAdapter: JsonAdapter<List<Category>?> =
            moshi.adapter<List<Category>?>(Types.newParameterizedType(List::class.java, Category::class.java), kotlin.collections.emptySet(), "categories")

    private val nullableStringAdapter: JsonAdapter<String?> =
            moshi.adapter<String?>(String::class.java, kotlin.collections.emptySet(), "createdTime")

    private val nullablePictureCollectionAdapter: JsonAdapter<PictureCollection?> =
            moshi.adapter<PictureCollection?>(PictureCollection::class.java, kotlin.collections.emptySet(), "header")

    private val nullableMetadataOfChannelConnectionsChannelInteractionsAdapter: JsonAdapter<Metadata<ChannelConnections, ChannelInteractions>?> =
            moshi.adapter<Metadata<ChannelConnections, ChannelInteractions>?>(Types.newParameterizedType(Metadata::class.java, ChannelConnections::class.java, ChannelInteractions::class.java), kotlin.collections.emptySet(), "metadata")

    private val nullablePrivacyAdapter: JsonAdapter<Privacy?> =
            moshi.adapter<Privacy?>(Privacy::class.java, kotlin.collections.emptySet(), "privacy")

    private val nullableListOfTagAdapter: JsonAdapter<List<Tag>?> =
            moshi.adapter<List<Tag>?>(Types.newParameterizedType(List::class.java, Tag::class.java), kotlin.collections.emptySet(), "tags")

    private val nullableUserAdapter: JsonAdapter<User?> =
            moshi.adapter<User?>(User::class.java, kotlin.collections.emptySet(), "user")

    override fun toString(): String = "GeneratedJsonAdapter(Channel)"

    override fun fromJson(reader: JsonReader): Channel {
        var categories: List<Category>? = null
        var categoriesSet: Boolean = false
        var createdTime: String? = null
        var createdTimeSet: Boolean = false
        var description: String? = null
        var descriptionSet: Boolean = false
        var header: PictureCollection? = null
        var headerSet: Boolean = false
        var link: String? = null
        var linkSet: Boolean = false
        var metadata: Metadata<ChannelConnections, ChannelInteractions>? = null
        var metadataSet: Boolean = false
        var modifiedTime: String? = null
        var modifiedTimeSet: Boolean = false
        var name: String? = null
        var nameSet: Boolean = false
        var pictures: PictureCollection? = null
        var picturesSet: Boolean = false
        var privacy: Privacy? = null
        var privacySet: Boolean = false
        var resourceKey: String? = null
        var resourceKeySet: Boolean = false
        var tags: List<Tag>? = null
        var tagsSet: Boolean = false
        var uri: String? = null
        var uriSet: Boolean = false
        var user: User? = null
        var userSet: Boolean = false
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 ->  {
                    categories = nullableListOfCategoryAdapter.fromJson(reader)
                    categoriesSet = true
                }
                1 ->  {
                    createdTime = nullableStringAdapter.fromJson(reader)
                    createdTimeSet = true
                }
                2 ->  {
                    description = nullableStringAdapter.fromJson(reader)
                    descriptionSet = true
                }
                3 ->  {
                    header = nullablePictureCollectionAdapter.fromJson(reader)
                    headerSet = true
                }
                4 ->  {
                    link = nullableStringAdapter.fromJson(reader)
                    linkSet = true
                }
                5 ->  {
                    metadata = nullableMetadataOfChannelConnectionsChannelInteractionsAdapter.fromJson(reader)
                    metadataSet = true
                }
                6 ->  {
                    modifiedTime = nullableStringAdapter.fromJson(reader)
                    modifiedTimeSet = true
                }
                7 ->  {
                    name = nullableStringAdapter.fromJson(reader)
                    nameSet = true
                }
                8 ->  {
                    pictures = nullablePictureCollectionAdapter.fromJson(reader)
                    picturesSet = true
                }
                9 ->  {
                    privacy = nullablePrivacyAdapter.fromJson(reader)
                    privacySet = true
                }
                10 ->  {
                    resourceKey = nullableStringAdapter.fromJson(reader)
                    resourceKeySet = true
                }
                11 ->  {
                    tags = nullableListOfTagAdapter.fromJson(reader)
                    tagsSet = true
                }
                12 ->  {
                    uri = nullableStringAdapter.fromJson(reader)
                    uriSet = true
                }
                13 ->  {
                    user = nullableUserAdapter.fromJson(reader)
                    userSet = true
                }
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = Channel()
        result = result.copy(
                categories = if (categoriesSet) categories else result.categories,
                createdTime = if (createdTimeSet) createdTime else result.createdTime,
                description = if (descriptionSet) description else result.description,
                header = if (headerSet) header else result.header,
                link = if (linkSet) link else result.link,
                metadata = if (metadataSet) metadata else result.metadata,
                modifiedTime = if (modifiedTimeSet) modifiedTime else result.modifiedTime,
                name = if (nameSet) name else result.name,
                pictures = if (picturesSet) pictures else result.pictures,
                privacy = if (privacySet) privacy else result.privacy,
                resourceKey = if (resourceKeySet) resourceKey else result.resourceKey,
                tags = if (tagsSet) tags else result.tags,
                uri = if (uriSet) uri else result.uri,
                user = if (userSet) user else result.user)
        return result
    }

    override fun toJson(writer: JsonWriter, value: Channel?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("categories")
        nullableListOfCategoryAdapter.toJson(writer, value.categories)
        writer.name("created_time")
        nullableStringAdapter.toJson(writer, value.createdTime)
        writer.name("description")
        nullableStringAdapter.toJson(writer, value.description)
        writer.name("header")
        nullablePictureCollectionAdapter.toJson(writer, value.header)
        writer.name("link")
        nullableStringAdapter.toJson(writer, value.link)
        writer.name("metadata")
        nullableMetadataOfChannelConnectionsChannelInteractionsAdapter.toJson(writer, value.metadata)
        writer.name("modified_time")
        nullableStringAdapter.toJson(writer, value.modifiedTime)
        writer.name("name")
        nullableStringAdapter.toJson(writer, value.name)
        writer.name("pictures")
        nullablePictureCollectionAdapter.toJson(writer, value.pictures)
        writer.name("privacy")
        nullablePrivacyAdapter.toJson(writer, value.privacy)
        writer.name("resource_key")
        nullableStringAdapter.toJson(writer, value.resourceKey)
        writer.name("tags")
        nullableListOfTagAdapter.toJson(writer, value.tags)
        writer.name("uri")
        nullableStringAdapter.toJson(writer, value.uri)
        writer.name("user")
        nullableUserAdapter.toJson(writer, value.user)
        writer.endObject()
    }
}
