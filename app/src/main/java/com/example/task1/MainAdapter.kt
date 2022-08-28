package com.example.task1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.view.*

class MainAdapter (val task : ArrayList<ModelTask.Task>, val listener: OnAdapterListener):
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
            )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = task[position]
        holder.view.tv_username.text = result.strSport
        holder.view.tv_format.text = result.strFormat
        Glide.with(holder.view)
            .load(result.strSportIconGreen)
            .placeholder(R.drawable.img_placeholder)
            .error(R.drawable.img_placeholder)
            .centerCrop()
            .into(holder.view.img_avatar)
        holder.view.setOnClickListener { listener.onClick( result ) }
    }

    override fun getItemCount() = task.size

    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view)

    fun setData(data: List<ModelTask.Task>){
        this.task.clear()
        this.task.addAll(data)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(result: ModelTask.Task)
    }

}