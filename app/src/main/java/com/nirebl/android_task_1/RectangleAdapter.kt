package com.nirebl.android_task_1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class RectangleAdapter(private val context: Context, private val items: MutableList<Int>) :
    RecyclerView.Adapter<RectangleAdapter.RectangleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RectangleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rectangle, parent, false)
        return RectangleViewHolder(view)
    }

    override fun onBindViewHolder(holder: RectangleViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun addItem() {
        items.add(items.size)
        notifyItemInserted(items.size - 1)
    }

    inner class RectangleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.textView)

        fun bind(number: Int) {
            textView.text = number.toString()
            val colorRes = if (number % 2 == 0) R.color.red else R.color.blue
            itemView.setBackgroundColor(ContextCompat.getColor(context, colorRes))
        }
    }
}
