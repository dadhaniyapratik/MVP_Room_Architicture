package com.vimeo.networking2;

import java.lang.System;

/**
 * * [TvodItem] publish information.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/vimeo/networking2/Publish;", "", "enabled", "", "time", "Ljava/util/Date;", "(Ljava/lang/Boolean;Ljava/util/Date;)V", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTime", "()Ljava/util/Date;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/util/Date;)Lcom/vimeo/networking2/Publish;", "equals", "other", "hashCode", "", "toString", "", "models"})
@com.squareup.moshi.JsonClass(generateAdapter = true)
public final class Publish {
    
    /**
     * * Whether the [TvodItem] has been published
     */
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean enabled = null;
    
    /**
     * * The time in IS 8601 format when this [TvodItem] was published.
     */
    @org.jetbrains.annotations.Nullable()
    private final java.util.Date time = null;
    
    /**
     * * Whether the [TvodItem] has been published
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getEnabled() {
        return null;
    }
    
    /**
     * * The time in IS 8601 format when this [TvodItem] was published.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date getTime() {
        return null;
    }
    
    public Publish(@org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "enabled")
    java.lang.Boolean enabled, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "time")
    java.util.Date time) {
        super();
    }
    
    public Publish() {
        super();
    }
    
    /**
     * * Whether the [TvodItem] has been published
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component1() {
        return null;
    }
    
    /**
     * * The time in IS 8601 format when this [TvodItem] was published.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date component2() {
        return null;
    }
    
    /**
     * * [TvodItem] publish information.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.vimeo.networking2.Publish copy(@org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "enabled")
    java.lang.Boolean enabled, @org.jetbrains.annotations.Nullable()
    @com.squareup.moshi.Json(name = "time")
    java.util.Date time) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}