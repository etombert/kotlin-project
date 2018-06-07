package com.example.elvinntombert.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.elvinntombert.myapplication.item.EventItem
import com.example.elvinntombert.myapplication.model.Event
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import kotlinx.android.synthetic.main.activity_home.*

class FavoritesEventsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites_events)

        val favoriteEvents = arrayListOf<Event>()
        favoriteEvents.add(Event("Disneyland Paris 25ème anniversaire", "Rue de Ravoli, 75001 Paris","21 juin - 10h30", "30€", "Loisir","0"))
        favoriteEvents.add(Event("Parc Astérix", "Rue de Ruvoli, 75001 Paris","23 juin - 11h30", "50€", "Loisir","1"))

        var linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        eventRecyclerView.layoutManager = linearLayoutManager
        val adapter = FastItemAdapter<EventItem>()

        adapter.add(favoriteEvents.map{ EventItem(it) })

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
