package com.xiphitech.myktapplication


import com.xiphitech.myktapplication.calculator.CalOutputInterfaceView
import com.xiphitech.myktapplication.calculator.CalOutputPresenter
import org.junit.Test
import org.mockito.BDDMockito
import org.mockito.Mockito

class CalOutputTest {

    private val mPresenter = CalOutputPresenter
    private val mView = Mockito.mock(CalOutputInterfaceView::class.java)

    @Test
    fun `1 plus 1`() {
        //GIVEN
        mPresenter.attach(mView)

        //WHEN first operand
        mPresenter.add("1")
        //THEN
        BDDMockito.then(mView).should().setEquation("1")

        //WHEN OPERATOR
        mPresenter.add("+")
        //THEN
        BDDMockito.then(mView).should().setEquation("1+")

        //WHEN OPERATOR
        mPresenter.add("1")
        //THEN
        BDDMockito.then(mView).should().setEquation("1+1")
        //THEN
        BDDMockito.then(mView).should().setOutcome("2")

        mPresenter.removeAll()
    }

    @Test
    fun `2 plus 2 minus 1 is 3`() {
        //GIVEN
        mPresenter.attach(mView)

        //WHEN first operand
        mPresenter.add("2")
        //THEN
        BDDMockito.then(mView).should().setEquation("2")

        //WHEN OPERATOR
        mPresenter.add("+")
        //THEN
        BDDMockito.then(mView).should().setEquation("2+")

        //WHEN OPERATOR
        mPresenter.add("2")
        //THEN
        BDDMockito.then(mView).should().setEquation("2+2")
        //THEN
        BDDMockito.then(mView).should().setOutcome("4")


        //WHEN OPERATOR
        mPresenter.add("-")
        //THEN
        BDDMockito.then(mView).should().setEquation("2+2-")


        //WHEN OPERATOR
        mPresenter.add("1")
        //THEN
        BDDMockito.then(mView).should().setEquation("2+2-1")
        //THEN
        BDDMockito.then(mView).should().setOutcome("3")
        mPresenter.removeAll()

    }

}