package com.nirebl.android_task_1

import android.annotation.SuppressLint
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
        val view = LayoutInflater.from(context).inflate(
            R.layout.item_rectangle, parent, false
        )
        return RectangleViewHolder(view)
    }

    override fun onBindViewHolder(holder: RectangleViewHolder, position: Int) {
        holder.bind(items[position])

        val layoutParams = holder.itemView.layoutParams
        val screenWidth = context.resources.displayMetrics.widthPixels
        val columnCount =
            if (
                context.resources.configuration.orientation ==
                android.content.res.Configuration.ORIENTATION_PORTRAIT
            ) {
                3
            } else {
                4
            }
        layoutParams.width = screenWidth / columnCount
        layoutParams.height = layoutParams.width
        holder.itemView.layoutParams = layoutParams
    }


    override fun getItemCount(): Int = items.size

    fun addItem() {
        items.add(items.size)
        notifyItemInserted(items.size - 1)
    }

    inner class RectangleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.textView)

        @SuppressLint("SetTextI18n")
        fun bind(number: Int) {
            textView.text = number.toString()
            val colorRes = if (number % 2 == 0) R.color.red else R.color.blue
            itemView.setBackgroundColor(ContextCompat.getColor(context, colorRes))
        }
    }
}
