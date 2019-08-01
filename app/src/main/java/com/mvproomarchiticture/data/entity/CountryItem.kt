package com.mvproomarchiticture.data.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity
data class CountryItem(
        @PrimaryKey(autoGenerate = true)
        @field:JsonProperty("id") var id: Int=0,
        @field:JsonProperty("name") var name: String = "",
        @field:JsonProperty("flag") var flag: String = ""):Parcelable{

        fun CountryItem(name: String,flag: String){
                this.name= name
                this.flag=flag
        }

}

//                       @field:JsonProperty("borders") var borders: MutableList<String> = mutableListOf(),
//        var isExpanded: Boolean = false) : Parcelable