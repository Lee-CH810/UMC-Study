package com.example.week3

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// 원래는 song, userID, Likes까지 저장하는 DB
@Database(entities = [Album::class], version=1)
abstract class SongDatabase: RoomDatabase() {
    abstract fun albumDao(): AlbumDao

    companion object {
        private var instance: SongDatabase? = null

        fun getInstance(context: Context): SongDatabase? {
            if (instance == null) {
                synchronized(SongDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SongDatabase::class.java,
                        "song-database"
                    ).allowMainThreadQueries().build()
                }
            }
            return instance
        }
    }
}