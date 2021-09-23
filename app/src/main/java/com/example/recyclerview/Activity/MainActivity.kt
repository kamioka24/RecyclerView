package com.example.recyclerview

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goToTopButton = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.goToTopButton)
        val goToBottomButton = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.goToBottomButton)
        val memoRecyclerView = findViewById<RecyclerView>(R.id.memoRecyclerView)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.setLogo(R.mipmap.ic_launcher) // ツールバーにロゴを設定
        setSupportActionBar(toolbar) // アクションバーにツールバーを設定

        val toolbarLayout = findViewById<com.google.android.material.appbar.CollapsingToolbarLayout>(R.id.toolbarLayout)
        toolbarLayout.title = getString(R.string.app_name)
        toolbarLayout.setExpandedTitleColor(Color.WHITE)
        toolbarLayout.setCollapsedTitleTextColor(R.color.teal_200) // 縮小時の文字色

        // データの生成
        val date = SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Date())
        val memoList = mutableListOf<Memo>()
        for (i in 1..300) {
            memoList.add(Memo("No.${i}", date, "羊が${i}匹"))
        }

        // RecyclerViewにAdapterとLayoutManagerを設定
        memoRecyclerView.also {
            recyclerView: RecyclerView ->
            recyclerView.adapter = MemoViewAdapter(this, memoList)
            recyclerView.layoutManager = LinearLayoutManager(this)
        }

        // 一番上へスクロール
        goToTopButton.setOnClickListener {
            memoRecyclerView.smoothScrollBy(0, -100000)
        }

        // 一番下へスクロール
        goToBottomButton.setOnClickListener {
            memoRecyclerView.smoothScrollBy(0, 100000)
        }
    }
}