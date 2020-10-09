package com.example.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private val fruitList = ArrayList<Fruit>()

    private fun initFruits() {
        repeat(2)
        {
            fruitList.add(Fruit(getRandomLengthString("鼠"), R.drawable.animal_0))
            fruitList.add(Fruit(getRandomLengthString("牛"), R.drawable.animal_1))
            fruitList.add(Fruit(getRandomLengthString("虎"), R.drawable.animal_2))
            fruitList.add(Fruit(getRandomLengthString("兔"), R.drawable.animal_3))
            fruitList.add(Fruit(getRandomLengthString("龙"), R.drawable.animal_4))
            fruitList.add(Fruit(getRandomLengthString("蛇"), R.drawable.animal_5))
            fruitList.add(Fruit(getRandomLengthString("马"), R.drawable.animal_6))
            fruitList.add(Fruit(getRandomLengthString("羊"), R.drawable.animal_7))
            fruitList.add(Fruit(getRandomLengthString("猴"), R.drawable.animal_8))
            fruitList.add(Fruit(getRandomLengthString("鸡"), R.drawable.animal_9))
            fruitList.add(Fruit(getRandomLengthString("狗"), R.drawable.animal_10))
            fruitList.add(Fruit(getRandomLengthString("猪"), R.drawable.animal_11))
        }
    }

    /**
     * 生成随机拷贝数量的字符串
     */
    private fun getRandomLengthString(string: String): String {
        val n = (1..20).random()
        val builder = StringBuilder()
        repeat(n) {
            builder.append(string)
        }
        return builder.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //数据初始化
        initFruits()
        //创建瀑布布局管理器
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        //设置布局管理器
        RecyclerViewTest.layoutManager = layoutManager
        //实例化数据适配器，装载数据
        val adapter = FruitAdapter(fruitList)
        //将数据适配器设置到控件上
        RecyclerViewTest.adapter = adapter
    }
}