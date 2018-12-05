package com.example.changan.kotlin_for_android_copy.data.db

import android.database.sqlite.SQLiteDatabase
import com.example.changan.kotlin_for_android_copy.BaseApplication
import org.jetbrains.anko.db.*

class ForecastDbHelper() : ManagedSQLiteOpenHelper(BaseApplication.instances,
    ForecastDbHelper.DB_NAME, null, ForecastDbHelper.DB_VERSION) {

    /**
     * 定义常量
     */
    companion object {
        val DB_NAME = "forecast.db"
        val DB_VERSION = 1
        val instance: ForecastDbHelper by lazy { ForecastDbHelper() }
    }
    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    override fun onCreate(db: SQLiteDatabase) {
        /*
        * 第一个参数是表的名称
            第二个参数,当是true的时候,创建之前会检查这个表是否存在。
            第三个参数是一个 Pair 类型的 vararg 参数。 vararg 也存在在Java中,
            这是一种在一个函数中传入联系很多相同类型的参数。这个函数也接收一个对
            象数组。
         */
        /*
        * Kotlin标准库中包含了一个叫 to 的
        函数,又一次,让我们来展示Kotlin的强大之处。它作为第一参数的扩展函数,接
        收另外一个对象作为参数,把两者组装并返回一个 Pair 。
        public fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)
        */

//        db.createTable(CityForecastTable.NAME, true,
//            Pair(CityForecastTable.ID, INTEGER + PRIMARY_KEY),
//            Pair(CityForecastTable.CITY, TEXT),
//            Pair(CityForecastTable.COUNTRY, TEXT)
//        )
        db.createTable(CityForecastTable.NAME, true,
            CityForecastTable.ID to INTEGER + PRIMARY_KEY,
            CityForecastTable.CITY to TEXT,
            CityForecastTable.COUNTRY to TEXT)

        db.createTable(DayForecastTable.NAME, true,
            DayForecastTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            DayForecastTable.DATE to INTEGER,
            DayForecastTable.DESCRIPTION to TEXT,
            DayForecastTable.HIGH to INTEGER,
            DayForecastTable.LOW to INTEGER,
            DayForecastTable.ICON_URL to TEXT,
            DayForecastTable.CITY_ID to INTEGER)
    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     *
     *
     *
     * The SQLite ALTER TABLE documentation can be found
     * [here](http://sqlite.org/lang_altertable.html). If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     *
     *
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     *
     *
     * @param db The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(CityForecastTable.NAME, true)
        db.dropTable(DayForecastTable.NAME, true)
        onCreate(db)
    }

}