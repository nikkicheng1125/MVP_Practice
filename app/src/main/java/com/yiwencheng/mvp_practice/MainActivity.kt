package com.yiwencheng.mvp_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),Contract.View {

    private lateinit var presenter:MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this,Model())

        init()

    }

    private fun init(){
        button_login.setOnClickListener {
            val email = edit_text_email.text.toString()
            val password = edit_text_password.text.toString()
            val user = User(email, password)

            presenter.login(user)
            presenter.onButtonClick()
        }
    }

    override fun onSuccess(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    override fun onError(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    override fun setString(str: String?) {
        Log.d("abc",str!!)
        text_view.text = str
    }
}