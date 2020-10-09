package com.example.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fruitList = ArrayList<Fruit>()

    private fun initFruits() {
        repeat(2)
        {
            fruitList.add(Fruit("鼠", R.drawable.animal_0))
            fruitList.add(Fruit("牛", R.drawable.animal_1))
            fruitList.add(Fruit("虎", R.drawable.animal_2))
            fruitList.add(Fruit("兔", R.drawable.animal_3))
            fruitList.add(Fruit("龙", R.drawable.animal_4))
            fruitList.add(Fruit("蛇", R.drawable.animal_5))
            fruitList.add(Fruit("马", R.drawable.animal_6))
            fruitList.add(Fruit("羊", R.drawable.animal_7))
            fruitList.add(Fruit("猴", R.drawable.animal_8))
            fruitList.add(Fruit("鸡", R.drawable.animal_9))
            fruitList.add(Fruit("狗", R.drawable.animal_10))
            fruitList.add(Fruit("猪", R.drawable.animal_11))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //数据初始化
        initFruits()
        //创建线性布局管理器
        val layoutManager = LinearLayoutManager(this)
        //设置线性方向为横向
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        //设置布局管理器
        RecyclerViewTest.layoutManager = layoutManager
        //实例化数据适配器，装载数据
        val adapter = FruitAdapter(fruitList)
        //将数据适配器设置到控件上
        RecyclerViewTest.adapter = adapter
    }
}