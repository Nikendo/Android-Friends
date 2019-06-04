package com.example.android_friends.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.android_friends.R
import com.example.android_friends.models.FriendModel
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class FriendsAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mFriendList: ArrayList<FriendModel> = arrayListOf()
    private var mSourceList: ArrayList<FriendModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.cell_friend, parent, false)
        return FriendsViewHolder(itemView = itemView)
    }

    override fun getItemCount(): Int {
        return mFriendList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is FriendsViewHolder) {
            holder.bind(mFriendList[position])
        }
    }

    fun setupFriends(friendList: ArrayList<FriendModel>) {
        mSourceList.clear()
        mSourceList.addAll(friendList)
        filter(query = "")
    }

    fun filter(query: String) {
        mFriendList.clear()
        mSourceList.forEach{
            if (it.name.contains(query, ignoreCase = true) || it.surname.contains(query, ignoreCase = true)) {
                mFriendList.add(it)
            } else {
                it.city?.let { city -> if (city.contains(query, ignoreCase = true)){
                    mFriendList.add(it)
                }}
            }
        }
        notifyDataSetChanged()
    }

    class FriendsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val avatar = itemView.findViewById<CircleImageView>(R.id.civ_avatar)
        val fullname = itemView.findViewById<TextView>(R.id.tv_fullname)
        val city = itemView.findViewById<TextView>(R.id.tv_city)
        val vOnline = itemView.findViewById<View>(R.id.view_online)

        fun bind(friendModel: FriendModel) {

            friendModel.avatar.let {url ->
                //Picasso.Builder(itemView.context).build().load(url).placeholder(R.drawable.ic_launcher_foreground).into(avatar)
                Picasso.with(itemView.context).load(url).into(avatar)
            }

            fullname.text = "${friendModel.name} ${friendModel.surname}"
            city.text = friendModel.city ?: itemView.context.getString(R.string.friend_no_city)

            if (friendModel.isOnline) {
                vOnline.visibility = View.VISIBLE
            } else {
                vOnline.visibility = View.GONE
            }
        }

    }

}