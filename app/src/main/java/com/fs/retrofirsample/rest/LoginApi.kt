package com.fs.retrofirsample.rest

import com.fs.retrofirsample.model.LoginRequestModel
import com.fs.retrofirsample.model.LoginResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {

    @POST("login")
    fun login(
        @Body loginRequestModel: LoginRequestModel
    ): Call<LoginResponseModel>

}