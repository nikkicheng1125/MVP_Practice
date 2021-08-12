package com.yiwencheng.mvp_practice

import android.util.Log
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainPresenter(private val view: Contract.View, private val model:Contract.Model) : Contract.Presenter,Contract.Model.OnFinishedListener {

    @Inject
    lateinit var apiService: ApiService

    val inject = DaggerComponent.builder().module(Module()).build().inject(this)

    override fun login(user: User) {
        try {
            val response = apiService.loginUser(user)
            val callback = object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    view.onSuccess("Login Successfully")
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    view.onSuccess("Login Fail")
                }
            }
            response.enqueue(callback)
        } catch (e: Exception) {
            Log.d("OkHttp", "Fail")
            view.onError("Login Failure")
            e.printStackTrace()
        }
//
//        if(response.isSuccessful){
//            view.onSuccess("Login Successfully")
//        }else{
//            val errorResponse = JSONObject(response.errorBody()?.string()!!)
//            view.onError("Login Failed")
//            //view.onError(errorResponse.getString("message"))
//        }

    }

    override fun onButtonClick() {
        model.getNextMsg(this)
    }

    override fun onFinished(msg: String?) {
        view.setString(msg)

    }
}