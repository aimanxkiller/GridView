package com.example.gridview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.gridview.model.ListFlag
import com.example.gridview.view.MainActivity
import com.example.gridview.R


class GridViewAdapter(private val context: Context, private val list: List<ListFlag>, private val main: MainActivity):RecyclerView.Adapter<GridViewAdapter.ViewHolder>(){

    private var selection:Int = -1

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var flag: ImageView
        init {
            name = itemView.findViewById(R.id.textViewFlagName)
            flag = itemView.findViewById(R.id.imageViewFlag)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context.applicationContext)
            .inflate(R.layout.itemgrid, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].name
        holder.flag.setImageResource(list[position].flag)

        customBorder(position,holder)

        holder.itemView.setOnClickListener {
            updateSelection(position)
            customActions(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    private fun customBorder(position: Int, holder: ViewHolder) {
        if (position == selection) {
            holder.itemView.setBackgroundResource(R.drawable.border)
        } else {
            holder.itemView.background = null
        }
    }

    private fun customActions(position: Int) {
        val title = main.findViewById<TextView>(R.id.textViewTitle)

        when(position){
            0,2 ->{
                Toast.makeText(context,"This is ${position+1}",Toast.LENGTH_SHORT).show()
                title.visibility = View.VISIBLE
                title.text = list[position].name
            }
            1 -> {
                title.visibility = View.GONE
                Toast.makeText(context, "This is ${position + 1}", Toast.LENGTH_SHORT).show()
            }
            3 -> {
                Toast.makeText(context, "This is ${position + 1}", Toast.LENGTH_SHORT).show()
                title.visibility = View.INVISIBLE
            }
        }
    }

    private fun updateSelection(position: Int) {
        val previousItemIndex = selection
        selection = position
        notifyItemChanged(previousItemIndex)
        notifyItemChanged(selection)
    }
}

