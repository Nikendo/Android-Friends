package com.example.android_friends.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.android_friends.models.FriendModel

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface FriendsView: MvpView {
    fun showError(messageId: Int)
    fun setupEmptyList()
    fun setupFriendsList(friendsList: ArrayList<FriendModel>)
    fun startLoading()
    fun endLoading()
}