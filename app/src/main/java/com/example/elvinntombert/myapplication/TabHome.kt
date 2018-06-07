package com.example.elvinntombert.myapplication


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.elvinntombert.myapplication.item.EventItem
import com.example.elvinntombert.myapplication.model.Event
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import kotlinx.android.synthetic.main.fragment_tab_home.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class TabHome : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_home, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val events = arrayListOf<Event>()
        events.add(Event("Lorem ipsum dolor sit amlet", "Rue de Rivoli, 75001 Paris","22 juin - 9h30", "25€","1"))
        events.add(Event("Lorem ipsum dolor sit amlet", "Rue de Rivoli, 75001 Paris","22 juin - 9h30", "25€","2"))
        events.add(Event("Lorem ipsum dolor sit amlet", "Rue de Rivoli, 75001 Paris","22 juin - 9h30", "25€","3"))
        events.add(Event("Lorem ipsum dolor sit amlet", "Rue de Rivoli, 75001 Paris","22 juin - 9h30", "25€","4"))

        var linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)


        view.eventRecyclerView.layoutManager = linearLayoutManager
        val adapter = FastItemAdapter<EventItem>()

        adapter.add(events.map{ EventItem(it) })

        // On lie le recyclerView à l'adaptateur
        view.eventRecyclerView.adapter = adapter

        adapter.withOnClickListener{v, adapter, item, position ->
            val event = item.event
            val intent = context?.let { EventDetailActivity.newIntent(it, event) }
            startActivity(intent)
//            if(context != null){
//            }
            true // on a consommé le tap sur le cellule
        }
    }


}
