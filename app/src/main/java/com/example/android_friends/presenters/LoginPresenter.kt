package com.example.android_friends.presenters

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.android_friends.R
import com.example.android_friends.views.LoginView

@InjectViewState
class LoginPresenter: MvpPresenter<LoginView>() {

    fun login(isSuccess: Boolean) {
        viewState.startLoading()
        Handler().postDelayed({
            viewState.endLoading()
            if (isSuccess) {
                viewState.openFriends()
            } else {
                viewState.showError(messageId = R.string.login_loading_failed_msg)
            }
        }, 500)
    }
}