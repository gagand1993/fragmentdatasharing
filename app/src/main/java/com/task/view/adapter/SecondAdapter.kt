package com.task.view.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.databinding.RowItemBinding
import com.task.model.DataShareModel

class SecondAdapter(private var list:ArrayList<DataShareModel>):RecyclerView.Adapter<SecondAdapter.ViewHolder>() {
    class ViewHolder(val binding:RowItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun updateList(list:ArrayList<DataShareModel>){
         this.list=list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder.binding){
            tvTitle.text=list[position].title

            if (list[position].isSelected){
                tvTitle.setTextColor(Color.WHITE)
                tvTitle.setBackgroundColor(Color.BLACK)

            }else{
                tvTitle.setTextColor(Color.BLACK)
                tvTitle.setBackgroundColor(Color.WHITE)
            }

            holder.itemView.setOnClickListener {
                list[position].isSelected=!list[position].isSelected
                notifyDataSetChanged()
            }

        }
    }


}