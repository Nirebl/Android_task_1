package com.nirebl.android_task_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: RectangleAdapter
    private val items = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        savedInstanceState?.let {
            val savedItems = it.getIntegerArrayList("items")
            if (savedItems != null) {
                items.addAll(savedItems)
            }
        }

        val columnCount = if (resources.configuration.orientation
            == android.content.res.Configuration.ORIENTATION_PORTRAIT
        ) {
            3
        } else {
            4
        }
        recyclerView.layoutManager = GridLayoutManager(this, columnCount)

        adapter = RectangleAdapter(this, items)
        recyclerView.adapter = adapter

        fab.setOnClickListener {
            adapter.addItem()
            recyclerView.smoothScrollToPosition(adapter.itemCount - 1)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntegerArrayList("items", ArrayList(items))
    }
}
