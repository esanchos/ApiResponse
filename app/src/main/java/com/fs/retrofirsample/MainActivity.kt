package com.fs.retrofirsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.fs.retrofirsample.model.LoginRequestModel
import com.fs.retrofirsample.rest.ApiErrorResponse
import com.fs.retrofirsample.rest.ApiSuccessResponse
import com.fs.retrofirsample.rest.Network.Companion.provideLoginApi
import com.fs.retrofirsample.rest.apiResponse
import org.jetbrains.anko.toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login()
    }

    private fun login() {
        provideLoginApi()
            .login(LoginRequestModel("email", "password"))
            .apiResponse {
                when (it) {
                    is ApiSuccessResponse -> toast(it.body.token)
                    is ApiErrorResponse -> toast(it.errorMessage)
                }
            }
    }

}
