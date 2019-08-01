package com.mvproomarchiticture.data.model.response

import com.fasterxml.jackson.annotation.JsonProperty

class ResultResponseVimeo<out T> {

    @JsonProperty("data")
    val data: T? = null
    }