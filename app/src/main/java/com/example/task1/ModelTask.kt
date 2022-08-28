package com.example.task1

data class ModelTask (val task: ArrayList<Task>) {
   data class Task(
      val idSport: String,
      val strSport: String,
      val strFormat: String,
      val strSportDescription: String,
      val strSportIconGreen: String,
      val strSportThumb: String)
}