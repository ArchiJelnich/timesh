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

    @Query("UPDATE calendar SET red=:count_to_add WHERE date = :current")
    fun updateR(count_to_add: Int, current:String)

    @Query("UPDATE calendar SET orange=:count_to_add WHERE date = :current")
    fun updateO(count_to_add: Int, current:String)

    @Query("UPDATE calendar SET yellow=:count_to_add WHERE date = :current")
    fun updateY(count_to_add: Int, current:String)

    @Query("UPDATE calendar SET green=:count_to_add WHERE date = :current")
    fun updateG(count_to_add: Int, current:String)

    @Query("UPDATE calendar SET blue=:count_to_add WHERE date = :current")
    fun updateB(count_to_add: Int, current:String)

    @Query("UPDATE calendar SET d_blue=:count_to_add WHERE date = :current")
    fun updateDB(count_to_add: Int, current:String)

    @Query("UPDATE calendar SET purple=:count_to_add WHERE date = :current")
    fun updatePP(count_to_add: Int, current:String)

    @Query("UPDATE calendar SET pink=:count_to_add WHERE date = :current")
    fun updateP(count_to_add: Int, current:String)

    @Query("UPDATE calendar SET grey=:count_to_add WHERE date = :current")
    fun updateGr(count_to_add: Int, current:String)

    @Query("UPDATE calendar SET black=:count_to_add WHERE date = :current")
    fun updateBl(count_to_add: Int, current:String)

    @Query("UPDATE calendar SET summ=:summ WHERE date = :current")
    fun updateSumm(summ: Int, current:String)

    @Delete
    fun delete(calendar: Calendar)

    @Query("DELETE FROM calendar")
    fun deleteAll()

}