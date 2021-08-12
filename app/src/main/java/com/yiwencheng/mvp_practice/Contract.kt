package com.yiwencheng.mvp_practice

interface Contract {
    interface View {
        fun onSuccess(msg: String)
        fun onError(msg: String)
        fun setString(str:String?)
    }

    interface Presenter{
        fun login(user: User)
        fun onButtonClick()
    }

    interface Model{
        interface OnFinishedListener{
            fun onFinished(msg:String?)
        }
        fun getNextMsg(onFinishedListener: OnFinishedListener?)
    }

}