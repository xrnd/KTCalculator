package com.xiphitech.myktapplication

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout

class CalOutputView(context : Context, attributeSet : AttributeSet) : LinearLayout(context,  attributeSet){

    init {

        orientation = VERTICAL
        gravity = Gravity.CENTER_VERTICAL
        //Inflate layout
       LayoutInflater.from(context).inflate(R.layout.calculator_top_view,this, true);

    }
}