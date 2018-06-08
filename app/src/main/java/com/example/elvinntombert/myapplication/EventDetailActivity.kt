package com.example.elvinntombert.myapplication

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.elvinntombert.myapplication.model.Event
import kotlinx.android.synthetic.main.activity_event_detail.*
import kotlinx.android.synthetic.main.activity_project.*

class EventDetailActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context, event: Event): Intent {
            val intent = Intent(context, EventDetailActivity::class.java)
            intent.putExtra("EXTRA_EVENT", event)

            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)


        buttonR.setOnClickListener {
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}
