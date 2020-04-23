package com.xiphitech.myktapplication.calculator

import bsh.Interpreter

object CalOutputPresenter {

    private var mView: CalOutputInterfaceView? = null

    private var mEquation: String = ""
    private var mOutcome: String = ""
    private var mInterpreter = Interpreter()

    fun add(item: String) {
        mEquation = mEquation.plus(item)
        updateEquation()
        calculateOutcome()
        updateOutcome()
    }

    fun removeLast() {
        mEquation = if (mEquation.length > 1) {
            mEquation.substring(0, mEquation.length - 1)
        } else {
            ""
        }
        updateEquation()
        calculateOutcome()
        updateOutcome()
    }

    fun removeAll() {
        mEquation = ""
        mOutcome = ""
        updateEquation()
        updateOutcome()
    }

    fun solve() {
        if (mOutcome.isEmpty()) {
            mEquation = mOutcome
            mOutcome = ""
        }
        updateEquation()
        updateOutcome()
    }

    private fun calculateOutcome() {

        if (!mEquation.isNullOrEmpty()) {
            try {
                mInterpreter.eval("result = $mEquation")
                val result = mInterpreter.get("result")

                if (result != null && result is Int) {
                    mOutcome = result.toString()
                } else {
                    mOutcome = ""
                }

            } catch (e: Exception) {
                mOutcome = ""
            }

        } else {
            mOutcome = ""
        }
    }

    private fun updateEquation() {
        mView?.setEquation(mEquation)
    }

    private fun updateOutcome() {
        mView?.setOutcome(mOutcome)
    }

    fun attach(view: CalOutputInterfaceView) {
        mView = view
    }

    fun detach() {
        mView = null
    }

}