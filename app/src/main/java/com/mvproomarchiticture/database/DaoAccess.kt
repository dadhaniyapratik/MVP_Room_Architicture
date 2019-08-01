package com.mvproomarchiticture.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.mvproomarchiticture.data.entity.CountryItem

@Dao
interface DaoAccess {
//    @Insert
//    void insertMultipleRecord(AlarmsModel... universities);

    @Insert
    fun insertCountryList(countryList: List<CountryItem>)

    @Insert
    fun insertSingleCountry(countryItem: CountryItem)

//    @Insert
//    void insertOnlySingleRecord(AlarmsModel university);

//    @Query("SELECT * FROM CountryItem")
    @Query("SELECT * FROM CountryItem ORDER BY name ASC")
    fun getCountryList(): List<CountryItem>

//    @Query("SELECT * FROM AlarmsModel WHERE id =:college_id")
//    AlarmsModel getSingleRecord(int college_id);
//
//    @Update
//    void updateRecord(AlarmsModel university);
//
//    @Delete
//    void deleteRecord(AlarmsModel university);

    @Query("DELETE FROM CountryItem")
    fun deleteCountryList()
}