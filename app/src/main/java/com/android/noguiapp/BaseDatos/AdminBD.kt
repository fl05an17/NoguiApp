package com.android.noguiapp.BaseDatos

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AdminBD(context: Context): SQLiteOpenHelper(context, DATABASE, null, 1){
    companion object{
        val DATABASE ="NoguiBD"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE Usuarios(" +
                "nom TEXT," +
                "email TEXT PRIMARY KEY," +
                "pass TEXT,)")
    }
    //funcion para madnar a ejecutar un INSERT, UPDATE o DELETE
    fun Ejecuta(sentencia: String): Boolean{
        try {
            val db = this.writableDatabase
            db.execSQL(sentencia)
            db.close()
            return true
        }
        catch (ex:Exception){
            return false
        }
    }

    fun Consulta (query: String): Cursor?{
        try {
            val db = this.readableDatabase
            return db.rawQuery(query,null)
        }
        catch (ex:Exception){
            return null
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}