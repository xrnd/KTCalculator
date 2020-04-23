package com.xiphitech.myktapplication.calculator

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.xiphitech.myktapplication.R
import kotlinx.android.synthetic.main.calculator_top_view.view.*

class CalOutputView(context: Context, attributeSet: AttributeSet) :
    LinearLayout(context, attributeSet)
    , CalOutputInterfaceView {

    init {

        orientation = VERTICAL
        gravity = Gravity.CENTER_VERTICAL
        //Inflate layout
        LayoutInflater.from(context).inflate(R.layout.calculator_top_view, this, true)
    }

    //<editor-fold desc="USER ACTIONS">
    fun removeLast() {
        CalOutputPresenter.removeLast()
    }

    fun add(item: String) {
        CalOutputPresenter.add(item)
    }

    fun removeAll() {
        CalOutputPresenter.removeAll()
    }

    fun solve() {
        CalOutputPresenter.solve()
    }
    //</editor-fold>


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        CalOutputPresenter.attach(this)
    }

    override fun detachAllViewsFromParent() {
        super.detachAllViewsFromParent()
        CalOutputPresenter.detach()
    }

    //<editor-fold desc="INTERFACE ACTIONS">
    override fun setEquation(equation: String) {
        typed_text.text = equation
    }

    override fun setOutcome(outcome: String) {
        calculated_text.text = outcome
    }
    //</editor-fold>



}