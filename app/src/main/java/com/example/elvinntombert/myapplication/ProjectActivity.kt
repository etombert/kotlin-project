package com.example.elvinntombert.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_project.*

class ProjectActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_project)

    button.setOnClickListener{
      var intent = Intent(this,HomeActivity::class.java)
      startActivity(intent)
    }
  }
}
