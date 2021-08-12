package com.yiwencheng.mvp_practice

import android.os.Handler

class Model:Contract.Model {

    override fun getNextMsg(onFinishedListener: Contract.Model.OnFinishedListener?) {
        Handler().postDelayed({onFinishedListener!!.onFinished("Welcome")},1000)
    }
}