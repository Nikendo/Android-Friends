package com.example.android_friends.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.android_friends.FriendsActivity
import com.example.android_friends.R
import com.example.android_friends.presenters.LoginPresenter
import com.example.android_friends.views.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : MvpAppCompatActivity(), LoginView {

    private val TAG = "LoginActivity"

    @InjectPresenter
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        setContentView(R.layout.activity_login)
//        presenter = LoginPresenter()

        btn_enter.setOnClickListener {
            presenter.login(isSuccess = true)
        }
    }

    override fun startLoading() {
        btn_enter.visibility = View.GONE
        cpv_loading.visibility = View.VISIBLE
    }

    override fun endLoading() {
        btn_enter.visibility = View.VISIBLE
        cpv_loading.visibility = View.GONE
    }

    override fun showError(messageId: Int) {
        Toast.makeText(this, getString(messageId), Toast.LENGTH_SHORT).show()
    }

    override fun openFriends() {
        startActivity(Intent(applicationContext, FriendsActivity::class.java))
    }
}
