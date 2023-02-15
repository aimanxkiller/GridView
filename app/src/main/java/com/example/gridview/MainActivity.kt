package com.example.gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var list:List<ListFlag>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var title:TextView = findViewById(R.id.textViewTitle)

        val recyclerView =findViewById<RecyclerView>(R.id.recyclerGrid)
        recyclerView.setHasFixedSize(true)
        val layoutManager = GridLayoutManager(this,2)
        recyclerView.layoutManager = layoutManager

        list = listOf(
            ListFlag("Malaysia",R.drawable.flag_malaysia),
            ListFlag("Canada",R.drawable.flag_canada),
            ListFlag("China",R.drawable.flag_china),
            ListFlag("Brazil",R.drawable.flag_brazil)
        )

        setGridView(recyclerView,list);

    }

    private fun setGridView(recyclerView: RecyclerView, list: List<ListFlag>) {
        val myAdapter = GridViewAdapter(this,list,this)

        recyclerView.adapter = myAdapter
    }


}