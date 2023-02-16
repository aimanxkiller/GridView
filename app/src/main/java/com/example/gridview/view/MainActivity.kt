package com.example.gridview.view

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gridview.R
import com.example.gridview.adapter.GridViewAdapter
import com.example.gridview.model.ListFlag

class MainActivity : AppCompatActivity(),AdapterListener {

    private lateinit var list:List<ListFlag>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView =findViewById<RecyclerView>(R.id.recyclerGrid)
        recyclerView.setHasFixedSize(true)
        val layoutManager = GridLayoutManager(this,2)
        recyclerView.layoutManager = layoutManager

        list = listOf(
            ListFlag("Malaysia", R.drawable.flag_malaysia),
            ListFlag("Canada", R.drawable.flag_canada),
            ListFlag("China", R.drawable.flag_china),
            ListFlag("Brazil", R.drawable.flag_brazil)
        )

        setGridView(recyclerView,list)

    }

    private fun setGridView(recyclerView: RecyclerView, list: List<ListFlag>) {
        val myAdapter = GridViewAdapter(this,list,this)

        recyclerView.adapter = myAdapter
    }

    override fun onClicked(position: Int) {
        val title = findViewById<TextView>(R.id.textViewTitle)

        when(position){
            0,2 ->{
                Toast.makeText(this,"This is ${position+1}", Toast.LENGTH_SHORT).show()
                title.visibility = View.VISIBLE
                title.text = list[position].name
            }
            1 -> {
                title.visibility = View.GONE
                Toast.makeText(this, "This is ${position + 1}", Toast.LENGTH_SHORT).show()
            }
            3 -> {
                Toast.makeText(this, "This is ${position + 1}", Toast.LENGTH_SHORT).show()
                title.visibility = View.INVISIBLE
            }
        }
    }


}