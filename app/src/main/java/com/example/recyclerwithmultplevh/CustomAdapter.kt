package com.example.recyclerwithmultplevh

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val mList: List<DataModel>) :
    ListAdapter<DataModel, CustomAdapter.ViewHolder>(ItemDifferentiator()) {

    class ViewHolder(itmView: View) : RecyclerView.ViewHolder(itmView) {

        private fun bindHeaderData(itm: DataModel.HeaderData) {
            val heading: TextView = itemView.findViewById<TextView>(R.id.heading)
            val desc: TextView = itemView.findViewById<TextView>(R.id.desc)

            heading.text = itm.title
            desc.text = itm.desc
        }

        private fun bindItemsViewModel(item: DataModel.ItemViewModel) {
            val name: TextView = itemView.findViewById(R.id.name)
            val email: TextView = itemView.findViewById(R.id.email)

            name.text = item.name
            email.text = item.email
        }

        fun bind(data: DataModel) {
            when (data) {
                is DataModel.HeaderData -> bindHeaderData(data)
                is DataModel.ItemViewModel -> bindItemsViewModel(data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = when (viewType) {
            TYPE_HEADER -> R.layout.header_layout
            TYPE_ITEM -> R.layout.item_list
            else -> throw IllegalArgumentException("Invalid view type")
        }

        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (mList[position]) {
            is DataModel.HeaderData -> TYPE_HEADER
            else -> TYPE_ITEM
        }
    }

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_ITEM = 1
    }

    class ItemDifferentiator : DiffUtil.ItemCallback<DataModel>() {

        override fun areItemsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
            return oldItem == newItem
        }

    }
}