package com.example.android_friends.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_friends.R
import com.example.android_friends.models.FriendModel

class FriendsAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mFriendList: ArrayList<FriendModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.cell_friend, parent, false)
        return FriendsViewHolder(itemView = itemView)
    }

    override fun getItemCount(): Int {
        return mFriendList.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {

    }

    class FriendsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

}