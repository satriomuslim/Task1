package com.example.task1.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.task1.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val username = findViewById<TextView>(R.id.tv_username)
        val format = findViewById<TextView>(R.id.tv_format)
        val desc = findViewById<TextView>(R.id.tv_description)

        username.text = intent.getStringExtra("intent_name")
        format.text = intent.getStringExtra("intent_format")
        desc.text = intent.getStringExtra("intent_desc")

        val intentImage = intent.getStringExtra("intent_image")
        Glide.with(this)
            .load(intentImage)
            .into(img_avatar)
    }
}