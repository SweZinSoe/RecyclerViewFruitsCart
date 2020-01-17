package com.szs.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.szs.myapplication.model.Fruit

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val fruitName = intent.getStringExtra("FRUIT_NAME")

        val name = findViewById<TextView>(R.id.txt_name).apply {
            text = fruitName
        }

        val fruitImage = intent.getIntExtra("\$500", R.drawable.blueberry)

        //"R.drawable.blueberry" is second picture if there is no picture

        val image = findViewById<ImageView>(R.id.images).apply {
            setImageResource(fruitImage)
        }
    }
}
