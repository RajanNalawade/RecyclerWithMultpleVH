package com.example.recyclerwithmultplevh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler_view = findViewById<RecyclerView>(R.id.recycler_view)
        recycler_view.layoutManager = LinearLayoutManager(this)

        val datas = ArrayList<DataModel>()

        datas.add(DataModel.HeaderData("Heading", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"))

        for(i in 1..20){
            datas.add(DataModel.ItemViewModel(
                "Pandiyan$i",
                "test$i@gmail.com"
            ))
        }

        val adapter = CustomAdapter(datas)
        recycler_view.adapter = adapter
    }
}