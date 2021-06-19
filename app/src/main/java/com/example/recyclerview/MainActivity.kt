package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // テストデータの生成
        val date = SimpleDateFormat("yyyy/MM/dd").format(Date())
        val memoList = mutableListOf<Memo>()
        repeat((0..100).count()) {
            memoList.add(Memo("ヤッホー！！", date))
        }

        // RecyclerViewにAdapterとLayoutManagerを設定
        findViewById<RecyclerView>(R.id.memoRecyclerView).also {
            recyclerView: RecyclerView ->
            recyclerView.adapter = MemoViewAdapter(this, memoList)
            recyclerView.layoutManager = LinearLayoutManager(this)
        }
    }
}