package com.xiphitech.myktapplication

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.calculator_bottom_view.view.*

class CalInputView(context : Context, attributeSet : AttributeSet) : RelativeLayout(context,  attributeSet){

    init {

        //Inflate layout
       LayoutInflater.from(context).inflate(R.layout.calculator_bottom_view,this, true);

        attributeSet?.run {
            val typedArray :TypedArray = context.obtainStyledAttributes(attributeSet,R.styleable.CalInputView)
            val inputName :String? = typedArray.getString(R.styleable.CalInputView_item_string)
            val inputIconRes :Int = typedArray.getResourceId(R.styleable.CalInputView_item_icon, -1)

            when{
                inputIconRes != -1 -> {
                    input_icon.apply {
                        visibility = View.VISIBLE;
                        setImageResource(inputIconRes)
                    }
                    input_text.visibility = View.GONE;
                }
                !inputName.isNullOrEmpty() -> {
                    input_text.apply{
                        visibility = View.VISIBLE;
                        setText(inputName)
                    }
                    input_icon.visibility = View.GONE
                }
                else -> {
                    input_text.visibility = View.GONE
                    input_icon.visibility = View.GONE
                }
            }

            typedArray.recycle()

        }
    }

    override fun setOnClickListener(l: OnClickListener?) {
        input_button.setOnClickListener(l)
    }
}