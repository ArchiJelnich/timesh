package com.example.myapplication

import androidx.room.*
import java.util.Date

@Entity(tableName="calendar")
public class Calendar() {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
    @ColumnInfo(name = "date") var date: String = ""
    @ColumnInfo(name = "red") var red: Int = 0
    @ColumnInfo(name = "orange") var orange: Int = 0
    @ColumnInfo(name = "yellow") var yellow: Int = 0
    @ColumnInfo(name = "green") var green: Int = 0
    @ColumnInfo(name = "blue") var blue: Int = 0
    @ColumnInfo(name = "d_blue") var d_blue: Int = 0
    @ColumnInfo(name = "pink") var pink: Int = 0
    @ColumnInfo(name = "purple") var purple: Int = 0
    @ColumnInfo(name = "black") var black: Int = 0
    @ColumnInfo(name = "grey") var grey: Int = 0
    @ColumnInfo(name = "summ") var summ: Int = 0

    constructor(date: String, red: Int, orange: Int, yellow: Int, green: Int, blue: Int, d_blue: Int, pink: Int, purple: Int, grey: Int, black: Int, summ: Int): this() {
        this.date = date
        this.red = red
        this.orange = orange
        this.yellow = yellow
        this.green = green
        this.blue = blue
        this.d_blue = d_blue
        this.purple = purple
        this.pink = pink
        this.grey = grey
        this.black = black
        this.summ = summ
        }

}




@Database(entities = [Calendar::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun calendarDao(): CalendarDao
}

