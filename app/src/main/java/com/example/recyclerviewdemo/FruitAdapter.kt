package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class FruitAdapter(private val fruitList: List<Fruit>) :
    RecyclerView.Adapter<FruitAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
        val fruitName: TextView = view.findViewById(R.id.fruitName)
        val fruitTime: TextView = view.findViewById(R.id.fruitTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_item_hor, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener{Toast.makeText(parent.context,"你点击了子视图",Toast.LENGTH_SHORT).show()}
        viewHolder.fruitImage.setOnClickListener{Toast.makeText(parent.context,"你点击了图片",Toast.LENGTH_SHORT).show()}
        viewHolder.fruitName.setOnClickListener{Toast.makeText(parent.context,"你点击了名字",Toast.LENGTH_SHORT).show()}
        viewHolder.fruitTime.setOnClickListener{Toast.makeText(parent.context,"你点击了时间",Toast.LENGTH_SHORT).show()}
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.fruitImage.setImageResource(fruit.imageId)
        holder.fruitName.text = fruit.name
        holder.fruitTime.text = getTime()
    }

    override fun getItemCount() = fruitList.count()

    private fun getTime(): String {
        val data = Date()
        val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.CHINA)
        return dateFormat.format(data)
    }
}