package com.vimeo.networking2.common;

import java.lang.System;

/**
 * * Defines a collection of interactions that contains a [follow] interaction of
 * * type [UpdatableInteraction].
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/vimeo/networking2/common/FollowableInteractions;", "", "follow", "Lcom/vimeo/networking2/common/UpdatableInteraction;", "getFollow", "()Lcom/vimeo/networking2/common/UpdatableInteraction;", "models"})
public abstract interface FollowableInteractions {
    
    /**
     * * An [UpdatableInteraction] that contains information on how
     *     * to follow an entity.
     */
    @org.jetbrains.annotations.Nullable()
    public abstract com.vimeo.networking2.common.UpdatableInteraction getFollow();
}