package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MemoViewAdapter(private val context: Context, private val memoList: List<Memo>) : RecyclerView.Adapter<MemoViewAdapter.MemoViewHolder>() {

    class MemoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userIcon = view.findViewById<ImageView>(R.id.userIcon)
        val userName = view.findViewById<TextView>(R.id.userName)
        val date = view.findViewById<TextView>(R.id.date)
        val content = view.findViewById<TextView>(R.id.content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder =
        MemoViewHolder(LayoutInflater.from(context).inflate(R.layout.memo, parent, false))

    override fun getItemCount(): Int = memoList.size

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        holder.userIcon.setImageResource(R.mipmap.ic_launcher)
        holder.userName.text = memoList[position].userName
        holder.date.text = memoList[position].date
        holder.content.text = memoList[position].content
    }
}