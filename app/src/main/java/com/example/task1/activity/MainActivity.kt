package com.example.task1.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task1.MainAdapter
import com.example.task1.ModelTask
import com.example.task1.R
import com.example.task1.api.ApiConfig
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val TAG: String = "MainActivity"
    private lateinit var mainadapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        getDataApi()
    }

    private fun setupRecyclerView(){
        mainadapter = MainAdapter(arrayListOf(), object : MainAdapter.OnAdapterListener {
            override fun onClick(result: ModelTask.Task) {
                startActivity(
                    Intent(this@MainActivity, DetailActivity::class.java)
                        .putExtra("intent_name", result.strSport)
                        .putExtra("intent_format", result.strFormat)
                        .putExtra("intent_image", result.strSportIconGreen)
                        .putExtra("intent_desc", result.strSportDescription)
                )
            }
        })
        rv_stories.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mainadapter
        }
    }

    override fun onStart(){
        super.onStart()
        getDataApi()
    }

    private fun getDataApi(){
        ApiConfig.endpoint.getdata()
            .enqueue(object : Callback<ModelTask> {
                override fun onFailure(call: Call<ModelTask>, t: Throwable) {
                    printLog( t.toString() )
                }
                override fun onResponse(
                    call: Call<ModelTask>,
                    response: Response<ModelTask>
                ) {
                    if (response.isSuccessful) {
                        showData(response.body()!!)
                    }
                }
            })
    }

    private fun printLog(message: String) {
        Log.d(TAG, message)
    }

    private fun showData(data: ModelTask) {
        for (sports in data.task) printLog("title: ${sports.idSport}")
        mainadapter.setData( data.task )
    }

}