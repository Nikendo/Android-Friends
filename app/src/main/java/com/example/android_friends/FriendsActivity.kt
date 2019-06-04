package com.example.android_friends

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.android_friends.adapters.FriendsAdapter
import com.example.android_friends.models.FriendModel
import com.example.android_friends.presenters.FriendsPresenter
import com.example.android_friends.views.FriendsView
import kotlinx.android.synthetic.main.activity_friends.*

class FriendsActivity : MvpAppCompatActivity(), FriendsView {

    private val TAG = "FriendsActivity"

    @InjectPresenter
    lateinit var presenter: FriendsPresenter
    private lateinit var mAdapter: FriendsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)
        Log.d(TAG, "onCreate()")
        presenter.loadFriends()
        mAdapter = FriendsAdapter()
        recycler_friends.adapter = mAdapter
        recycler_friends.layoutManager = LinearLayoutManager(this)
        recycler_friends.setHasFixedSize(true)

        et_friends_search.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                mAdapter.filter(query = s.toString())
            }

        })
    }

    override fun showError(messageId: Int) {
        tv_friends_error.text = getString(messageId)
    }

    override fun setupEmptyList() {
        recycler_friends.visibility = View.GONE
        tv_friends_error.visibility = View.VISIBLE
    }

    override fun setupFriendsList(friendsList: ArrayList<FriendModel>) {
        recycler_friends.visibility = View.VISIBLE
        tv_friends_error.visibility = View.GONE
        mAdapter.setupFriends(friendList = friendsList)
    }

    override fun startLoading() {
        recycler_friends.visibility = View.GONE
        tv_friends_error.visibility = View.GONE
        cpv_friends.visibility = View.VISIBLE
    }

    override fun endLoading() {
        cpv_friends.visibility = View.GONE
    }

}
