package com.example.android_friends.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.android_friends.R
import com.example.android_friends.models.FriendModel
import com.example.android_friends.providers.FriendsProvider
import com.example.android_friends.views.FriendsView

@InjectViewState
class FriendsPresenter: MvpPresenter<FriendsView>() {
    fun loadFriends() {
        viewState.startLoading()
        FriendsProvider(presenter = this).testLoadFriends(hasFriends = true)
    }

    fun friendsLoaded(friendsList: ArrayList<FriendModel>) {
        viewState.endLoading()
        if (friendsList.size == 0) {
            viewState.setupEmptyList()
            viewState.showError(messageId = R.string.friends_no_items)
        } else {
            viewState.setupFriendsList(friendsList = friendsList)
        }
    }


}