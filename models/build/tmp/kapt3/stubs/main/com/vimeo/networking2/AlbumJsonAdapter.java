package com.vimeo.networking2;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0016J\u001a\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010&\u001a\u00020\u0019H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00110\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u0013\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00140\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/vimeo/networking2/AlbumJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/vimeo/networking2/Album;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableAlbumEmbedAdapter", "Lcom/vimeo/networking2/AlbumEmbed;", "nullableAlbumPrivacyAdapter", "Lcom/vimeo/networking2/AlbumPrivacy;", "nullableBooleanAdapter", "", "nullableDateAdapter", "Ljava/util/Date;", "nullableIntAdapter", "", "nullableListOfPictureCollectionAdapter", "", "Lcom/vimeo/networking2/PictureCollection;", "nullableMetadataOfAlbumConnectionsAlbumInteractionsAdapter", "Lcom/vimeo/networking2/Metadata;", "Lcom/vimeo/networking2/AlbumConnections;", "Lcom/vimeo/networking2/AlbumInteractions;", "nullablePictureCollectionAdapter", "nullableStringAdapter", "", "nullableUserAdapter", "Lcom/vimeo/networking2/User;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "models"})
public final class AlbumJsonAdapter extends com.squareup.moshi.JsonAdapter<com.vimeo.networking2.Album> {
    private final com.squareup.moshi.JsonReader.Options options = null;
    private final com.squareup.moshi.JsonAdapter<java.lang.String> nullableStringAdapter = null;
    private final com.squareup.moshi.JsonAdapter<java.util.Date> nullableDateAdapter = null;
    private final com.squareup.moshi.JsonAdapter<com.vimeo.networking2.PictureCollection> nullablePictureCollectionAdapter = null;
    private final com.squareup.moshi.JsonAdapter<java.lang.Integer> nullableIntAdapter = null;
    private final com.squareup.moshi.JsonAdapter<com.vimeo.networking2.AlbumEmbed> nullableAlbumEmbedAdapter = null;
    private final com.squareup.moshi.JsonAdapter<java.lang.Boolean> nullableBooleanAdapter = null;
    private final com.squareup.moshi.JsonAdapter<com.vimeo.networking2.Metadata<com.vimeo.networking2.AlbumConnections, com.vimeo.networking2.AlbumInteractions>> nullableMetadataOfAlbumConnectionsAlbumInteractionsAdapter = null;
    private final com.squareup.moshi.JsonAdapter<java.util.List<com.vimeo.networking2.PictureCollection>> nullableListOfPictureCollectionAdapter = null;
    private final com.squareup.moshi.JsonAdapter<com.vimeo.networking2.AlbumPrivacy> nullableAlbumPrivacyAdapter = null;
    private final com.squareup.moshi.JsonAdapter<com.vimeo.networking2.User> nullableUserAdapter = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.vimeo.networking2.Album fromJson(@org.jetbrains.annotations.NotNull()
    com.squareup.moshi.JsonReader reader) {
        return null;
    }
    
    @java.lang.Override()
    public void toJson(@org.jetbrains.annotations.NotNull()
    com.squareup.moshi.JsonWriter writer, @org.jetbrains.annotations.Nullable()
    com.vimeo.networking2.Album value) {
    }
    
    public AlbumJsonAdapter(@org.jetbrains.annotations.NotNull()
    com.squareup.moshi.Moshi moshi) {
        super();
    }
}