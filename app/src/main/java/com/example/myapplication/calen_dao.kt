package com.example.myapplication

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CalendarDao {
    @Query("SELECT * FROM calendar")
    fun getAll(): List<Calendar>

    @Query("SELECT * FROM calendar WHERE date=:date ")
    fun findByDate(date: String): Calendar

    @Insert
    fun insertAll(vararg calendar: Calendar)

    @Delete
    fun delete(calendar: Calendar)

    @Query("DELETE FROM calendar")
    fun deleteAll()

}