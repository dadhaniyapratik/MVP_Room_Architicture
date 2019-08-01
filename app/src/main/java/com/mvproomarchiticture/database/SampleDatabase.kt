package com.mvproomarchiticture.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.mvproomarchiticture.data.entity.CountryItem

//
//@Database(entities = [CountryItem::class], version = 1, exportSchema = false)
//abstract class SampleDatabase : RoomDatabase {
//    private var instance: SampleDatabase? = null
//    abstract fun daoAccess(): DaoAccess
//
//
//    companion object data{ fun getAppDatabase(context: Context): SampleDatabase {
//        if (instance == null) {
//            instance = Room.databaseBuilder<SampleDatabase>(context.applicationContext,
//                    SampleDatabase::class.java,
//                    "sample-db")
//                    .allowMainThreadQueries()
//                    .build()
//        }
//        return instance
//    }
//    }
//}

@Database(entities = [CountryItem::class], version = 1)
abstract class SampleDatabase : RoomDatabase() {
    abstract fun daoAccess(): DaoAccess
    companion object {
        private var INSTANCE: SampleDatabase? = null
        fun getDatabase(context: Context): SampleDatabase? {
            if (INSTANCE == null) {
                synchronized(SampleDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            SampleDatabase::class.java, "SampleDatabase.db"
                    ).allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }
    }
}