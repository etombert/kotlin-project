package com.example.elvinntombert.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.elvinntombert.myapplication.item.EventItem
import com.example.elvinntombert.myapplication.model.Event
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val events = arrayListOf<Event>()
        events.add(Event("Lorem ipsum dolor sit amlet", "Rue de Rivoli, 75001 Paris","22 juin - 9h30", "25€","1"))
        events.add(Event("Lorem ipsum dolor sit amlet", "Rue de Rivoli, 75001 Paris","22 juin - 9h30", "25€","2"))
        events.add(Event("Lorem ipsum dolor sit amlet", "Rue de Rivoli, 75001 Paris","22 juin - 9h30", "25€","3"))
        events.add(Event("Lorem ipsum dolor sit amlet", "Rue de Rivoli, 75001 Paris","22 juin - 9h30", "25€","4"))

        var linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        eventRecyclerView.layoutManager = linearLayoutManager
        val adapter = FastItemAdapter<EventItem>()

        adapter.add(events.map{ EventItem(it)})

        // On lie le recyclerView à l'adaptateur
        eventRecyclerView.adapter = adapter

        adapter.withOnClickListener{v, adapter, item, position ->
            val event = item.event
            val intent = EventDetailActivity.newIntent(this, event)
            startActivity(intent)
            true // on a consommé le tap sur le cellule
        }
    }
}
