package com.data.sqliteandroid.mvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import com.data.sqliteandroid.databinding.RecyclerItemBinding

class UserRecyclerViewAdapter ( var items: ArrayList<User>,
                                var listener: OnItemClickListener)
    : RecyclerView.Adapter<UserRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder( var binding: RecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User,listener: OnItemClickListener){
            binding.user=user

            if (listener!=null){
                binding.root.setOnClickListener {
                        _ ->listener.onItemClick(layoutPosition)
                }
            }

            binding.executePendingBindings()

        }
    }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = RecyclerItemBinding.inflate(layoutInflater, parent, false)

            return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        holder.bind(items[position],listener)
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

}

