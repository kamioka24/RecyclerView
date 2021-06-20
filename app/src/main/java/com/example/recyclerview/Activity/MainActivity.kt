package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goToTopButton = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.goToTopButton)
        val appbar = findViewById<com.google.android.material.appbar.AppBarLayout>(R.id.appbar)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.setLogo(R.mipmap.ic_launcher) // ツールバーにロゴを設定
        setSupportActionBar(toolbar)

        // データの生成
        val date = SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Date())
        val memoList = mutableListOf<Memo>()
        for (i in 1..300) {
            memoList.add(Memo("No.${i}", date, "羊が${i}匹"))
        }

        // RecyclerViewにAdapterとLayoutManagerを設定
        findViewById<RecyclerView>(R.id.memoRecyclerView).also {
            recyclerView: RecyclerView ->
            recyclerView.adapter = MemoViewAdapter(this, memoList)
            recyclerView.layoutManager = LinearLayoutManager(this)
        }

        goToTopButton.setOnClickListener {
            appbar.scrollTo(0, 0)
        }
    }
}