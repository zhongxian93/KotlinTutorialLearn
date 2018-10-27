package com.example.zhongxian.kotlintutoriallearn

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.content.Context
import android.util.Log


class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

    companion object{
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "Question.db"

        private val SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TableInfo.TABLE_NAME + " (" + TableInfo.COLUMN_QUESTION_NUMBER + " TEXT PRIMARY KEY," +
                        TableInfo.COLUMN_ANSWER + " TEXT)"

        private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " +
                TableInfo.TABLE_NAME
    }

    override fun onCreate(db: SQLiteDatabase?){
        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?,
                           oldVersion: Int, newVersion:Int){
        db?.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }
    override fun onDowngrade(db: SQLiteDatabase?,
                             oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    //Return Boolean to tell if the course
    // inserted successfully
    fun insertQuestionAns(course: DataRecord):Boolean{
        val db = writableDatabase
        val values = ContentValues()

        values.put(TableInfo.COLUMN_QUESTION_NUMBER, course.questionNumber)
        values.put(TableInfo.COLUMN_ANSWER, course.answer)

        val newRowId = db.insert(TableInfo.TABLE_NAME,
                null, values)

        return true
    }


    fun readQuestionAns(questionNumber: String): ArrayList<DataRecord>{
        val userAns = ArrayList<DataRecord>()
        val db = writableDatabase
        var cursor: Cursor? = null

        try{
            cursor = db.rawQuery("select * from " +  //Note the spaces
                    TableInfo.TABLE_NAME + " WHERE " +
                    TableInfo.COLUMN_QUESTION_NUMBER + "=" + questionNumber + "", null)
        }catch(e: SQLiteException){
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }
        var questionNumber: String
        var answer: String

        if(cursor!!.moveToFirst()){
            while(cursor.isAfterLast == false){             //Now you're passing through the results returned by the query
                questionNumber = cursor.getString(cursor.getColumnIndex(TableInfo.COLUMN_QUESTION_NUMBER))
                answer = cursor.getString(cursor.getColumnIndex(TableInfo.COLUMN_ANSWER))
                userAns.add(DataRecord(questionNumber, answer))
                cursor.moveToNext()                         //Move to the next retrieved results
            }
        }
        return userAns                                       //course contains all the records of course retrieved

    }

    fun updateQuestionAns(questionNumber: String, answer: String) {
        val db = this.writableDatabase
        var values = ContentValues()
        values.put(TableInfo.COLUMN_QUESTION_NUMBER, questionNumber)
        values.put(TableInfo.COLUMN_ANSWER, answer)

        val retVal = db.update(TableInfo.TABLE_NAME, values, TableInfo.COLUMN_QUESTION_NUMBER+" = " + questionNumber, null)
        if (retVal >= 1) {
            Log.v("@@@WWe", " Record updated")
        } else {
            Log.v("@@@WWe", " Not updated")
        }
        db.close()

    }


}