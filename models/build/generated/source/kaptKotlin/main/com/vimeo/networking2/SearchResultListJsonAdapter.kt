// Code generated by moshi-kotlin-codegen. Do not edit.
package com.vimeo.networking2

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.NullPointerException
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

class SearchResultListJsonAdapter(moshi: Moshi) : JsonAdapter<SearchResultList>() {
    private val options: JsonReader.Options =
            JsonReader.Options.of("facets", "mature_hidden_count", "total", "page", "per_page", "paging", "data")

    private val nullableSearchFacetCollectionAdapter: JsonAdapter<SearchFacetCollection?> =
            moshi.adapter<SearchFacetCollection?>(SearchFacetCollection::class.java, kotlin.collections.emptySet(), "facetCollection")

    private val nullableIntAdapter: JsonAdapter<Int?> =
            moshi.adapter<Int?>(Int::class.javaObjectType, kotlin.collections.emptySet(), "matureHiddenCount")

    private val nullablePagingAdapter: JsonAdapter<Paging?> =
            moshi.adapter<Paging?>(Paging::class.java, kotlin.collections.emptySet(), "paging")

    private val nullableListOfSearchResultAdapter: JsonAdapter<List<SearchResult>?> =
            moshi.adapter<List<SearchResult>?>(Types.newParameterizedType(List::class.java, SearchResult::class.java), kotlin.collections.emptySet(), "data")

    override fun toString(): String = "GeneratedJsonAdapter(SearchResultList)"

    override fun fromJson(reader: JsonReader): SearchResultList {
        var facetCollection: SearchFacetCollection? = null
        var facetCollectionSet: Boolean = false
        var matureHiddenCount: Int? = null
        var matureHiddenCountSet: Boolean = false
        var total: Int? = null
        var totalSet: Boolean = false
        var page: Int? = null
        var pageSet: Boolean = false
        var perPage: Int? = null
        var perPageSet: Boolean = false
        var paging: Paging? = null
        var pagingSet: Boolean = false
        var data: List<SearchResult>? = null
        var dataSet: Boolean = false
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 ->  {
                    facetCollection = nullableSearchFacetCollectionAdapter.fromJson(reader)
                    facetCollectionSet = true
                }
                1 ->  {
                    matureHiddenCount = nullableIntAdapter.fromJson(reader)
                    matureHiddenCountSet = true
                }
                2 ->  {
                    total = nullableIntAdapter.fromJson(reader)
                    totalSet = true
                }
                3 ->  {
                    page = nullableIntAdapter.fromJson(reader)
                    pageSet = true
                }
                4 ->  {
                    perPage = nullableIntAdapter.fromJson(reader)
                    perPageSet = true
                }
                5 ->  {
                    paging = nullablePagingAdapter.fromJson(reader)
                    pagingSet = true
                }
                6 ->  {
                    data = nullableListOfSearchResultAdapter.fromJson(reader)
                    dataSet = true
                }
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()
        var result = SearchResultList()
        result = result.copy(
                facetCollection = if (facetCollectionSet) facetCollection else result.facetCollection,
                matureHiddenCount = if (matureHiddenCountSet) matureHiddenCount else result.matureHiddenCount,
                total = if (totalSet) total else result.total,
                page = if (pageSet) page else result.page,
                perPage = if (perPageSet) perPage else result.perPage,
                paging = if (pagingSet) paging else result.paging,
                data = if (dataSet) data else result.data)
        return result
    }

    override fun toJson(writer: JsonWriter, value: SearchResultList?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        writer.name("facets")
        nullableSearchFacetCollectionAdapter.toJson(writer, value.facetCollection)
        writer.name("mature_hidden_count")
        nullableIntAdapter.toJson(writer, value.matureHiddenCount)
        writer.name("total")
        nullableIntAdapter.toJson(writer, value.total)
        writer.name("page")
        nullableIntAdapter.toJson(writer, value.page)
        writer.name("per_page")
        nullableIntAdapter.toJson(writer, value.perPage)
        writer.name("paging")
        nullablePagingAdapter.toJson(writer, value.paging)
        writer.name("data")
        nullableListOfSearchResultAdapter.toJson(writer, value.data)
        writer.endObject()
    }
}
