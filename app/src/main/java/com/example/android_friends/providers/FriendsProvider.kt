package com.example.android_friends.providers

import android.os.Handler
import com.example.android_friends.models.FriendModel
import com.example.android_friends.presenters.FriendsPresenter

class FriendsProvider(var presenter: FriendsPresenter) {
    fun testLoadFriends(hasFriends: Boolean) {
        Handler().postDelayed({
            val friendsList: ArrayList<FriendModel> = ArrayList()
            if (hasFriends) {
                val friend1 = FriendModel("Александр", "Рязанцев", "Москва",
                    "https://pp.userapi.com/c851016/v851016683/b96bc/9xcNAuHXZPg.jpg", true)
                val friend2 = FriendModel("Павел", "Боровских", "Белово",
                    "https://pp.userapi.com/c847020/v847020196/10fa2a/ePqF8Qeftg4.jpg", true)
                val friend3 = FriendModel("Кирилл", "Поташ", "Инской",
                    "https://pp.userapi.com/c847121/v847121358/172c1a/6vDWhLWMkIY.jpg", false)
                friendsList.add(friend1)
                friendsList.add(friend2)
                friendsList.add(friend3)
            } else {

            }
            presenter.friendsLoaded(friendsList = friendsList)
        }, 2000)
    }
}