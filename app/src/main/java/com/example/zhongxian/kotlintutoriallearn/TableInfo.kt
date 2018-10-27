package com.example.zhongxian.kotlintutoriallearn

import android.provider.BaseColumns

class TableInfo : BaseColumns {
    // static use to define structure of the table
    companion object {
        val TABLE_NAME = "USERANS"
        val COLUMN_QUESTION_NUMBER = "questionNumber"
        val COLUMN_ANSWER = "answer"
    }

}