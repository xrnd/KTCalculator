package com.xiphitech.myktapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        key_0.setOnClickListener { cal_top_view.add("0") }
        key_1.setOnClickListener { cal_top_view.add("1") }
        key_2.setOnClickListener { cal_top_view.add("2") }
        key_3.setOnClickListener { cal_top_view.add("3") }
        key_4.setOnClickListener { cal_top_view.add("4") }
        key_5.setOnClickListener { cal_top_view.add("5") }
        key_6.setOnClickListener { cal_top_view.add("6") }
        key_7.setOnClickListener { cal_top_view.add("7") }
        key_8.setOnClickListener { cal_top_view.add("8") }
        key_9.setOnClickListener { cal_top_view.add("9") }

        key_clear.setOnClickListener { cal_top_view.removeAll() }
        key_backspace.setOnClickListener { cal_top_view.removeLast() }
        key_equals.setOnClickListener { cal_top_view.solve() }

        key_plus.setOnClickListener { cal_top_view.add("+") }
        key_divide.setOnClickListener { cal_top_view.add("/") }
        key_multiply.setOnClickListener { cal_top_view.add("*") }
        key_minus.setOnClickListener { cal_top_view.add("-") }

        key_percent.setOnClickListener { cal_top_view.add("%") }
    }


}
