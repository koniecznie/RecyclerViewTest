package com.example.recyclerviewtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var photoAdapter: PhotoAdapter
    private var dataList = mutableListOf<DataModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //inicjujemy siatkę z 2 polami w rzędzie

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
        photoAdapter = PhotoAdapter()
        recyclerView.adapter = photoAdapter
        //dodajemy dane
        dataList.add(DataModel("Mruczek", "The Sus one", R.drawable.cat))
        dataList.add(DataModel("Mruczek", "The Shooked one", R.drawable.cat2))
        dataList.add(DataModel("Mruczek", "The cry baby", R.drawable.cat3))
        dataList.add(DataModel("Mru", "czek", R.drawable.cat4))
        dataList.add(DataModel("Mruczek", "The bitch", R.drawable.cat5))
        dataList.add(DataModel("Mru", "uuuu", R.drawable.cat6))
        photoAdapter.setDataList(dataList)
    }
}
