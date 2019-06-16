package com.example.calorieassistant.sign.`in`

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import android.arch.lifecycle.ViewModel
import com.example.calorieassistant.App
import com.example.calorieassistant.models.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SignInViewModel : ViewModel() {

    private lateinit var user: User

    fun setUser(user: User) {
        this.user = user
    }

    fun onButtonLoginClicked(): LiveData<Boolean> {
        return LiveDataReactiveStreams.fromPublisher(App.getInstance().restApi.signIn(user.toRemote())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .map {
                it.token?.let { return@map true }
                it.error?.let { return@map false }
                false
            }
            .onErrorReturn {
                false
            }
            .toFlowable())
    }
}