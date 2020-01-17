package com.szs.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.szs.myapplication.R
import com.szs.myapplication.model.Fruit
import kotlinx.android.synthetic.main.fruit_items.view.*

//its work is declaring item from fruit
//call id of data form fruit_item layout in order to input into recyclerView
class FruitsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var fruitName = itemView.findViewById<TextView>(R.id.txt_name)
    var fruitImage = itemView.findViewById<ImageView>(R.id.fruit_image)
    var itemCount = itemView.findViewById<TextView>(R.id.txt_count)
    var btnCount = itemView.findViewById<Button>(R.id.btn_count)


    //"OnItemClickListener" calls interface
    fun bind (fruits: Fruit, clickListener: OnItemClickListener){
        itemView.setOnClickListener{
            clickListener.onItemClicked(fruits)
        }
    }

}

class FruitsAdapter (val fruitsList: ArrayList<Fruit>, val itemClickListener: OnItemClickListener):RecyclerView.Adapter<FruitsViewHolder>() {

    //layout inflater means
    //insert fruit item layout into recyclerView layout
    //declaration
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_items,parent,false)
        return FruitsViewHolder(view)
    }
    //'context' indicates activity
    //'this' indicates where it is


    override fun getItemCount(): Int {
        return fruitsList.size
    }
    //this fun shows how many array room in layout


    override fun onBindViewHolder(holder: FruitsViewHolder, position: Int) {
        holder.fruitName.text=fruitsList[position].name
        holder.fruitImage.setImageResource(fruitsList[position].image)
        holder.btnCount.setOnClickListener {
            var count: Int = holder.itemCount.text.toString().toInt()
            count++

//            holder.itemCount.text = count.toString()
//            holder.itemCount.text = "USD$ ${count.toString()}"
            holder.itemCount.text = count.toString()
        }
        holder.bind(fruitsList[position],itemClickListener)
    }
    //assign item value in there
}


//in order to make 'onClickListener' on recyclerView

interface OnItemClickListener{
    fun onItemClicked(fruits: Fruit)//no implementation with function only
}
