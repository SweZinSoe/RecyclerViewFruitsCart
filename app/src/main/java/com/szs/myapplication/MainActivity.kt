package com.szs.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.szs.myapplication.adapter.FruitsAdapter
import com.szs.myapplication.adapter.OnItemClickListener
import com.szs.myapplication.model.Fruit

class MainActivity : AppCompatActivity(), OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.fruits_recycler)

        val fruitArray = ArrayList<Fruit>()

        fruitArray.add(Fruit("Apple", R.drawable.apple))
        fruitArray.add(Fruit("Orange", R.drawable.orange))
        fruitArray.add(Fruit("Blueberry", R.drawable.blueberry))
        fruitArray.add(Fruit("Strawberry", R.drawable.straw))

        val fruitsAdapter = FruitsAdapter(fruitArray, this)

        ///recycler view is combination of grid view and list view
        ///'layoutManager' is for list view
//        recyclerView.layoutManager = LinearLayoutManager(this) //this is vertical
//        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)    //this is horizontal

        ///grid view
//        recyclerView.layoutManager = GridLayoutManager(this, 2)
//        recyclerView.adapter = fruitsAdapter
        recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = fruitsAdapter
        }

    }

    override fun onItemClicked(fruits: Fruit) {
        Toast.makeText(this, "${fruits.name}", Toast.LENGTH_LONG).show()
        val intent = Intent(this, CartActivity::class.java).apply {

            putExtra("FRUIT_NAME", fruits.name)

            putExtra("$500", fruits.image)
        }

        //there is no need "intent" keyword by using ".apply()"
        ///"Intent" goes from one activity to other activity

//        intent.putExtra("FRUIT_NAME",fruits.name)

        startActivity(intent)
    }
}



