package com.fs.retrofirsample.rest

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun <T> Call<T>.apiResponse(callback: (ApiResponse<T>) -> Unit) = run{
    enqueue(object: Callback<T> {
        override fun onFailure(call: Call<T>, t: Throwable) {
            callback(ApiResponse.create(t))
        }

        override fun onResponse(call: Call<T>, response: Response<T>) {
            callback(ApiResponse.create(response))
        }
    })
}