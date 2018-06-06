package com.example.elvinntombert.myapplication.item

import android.view.View
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import com.example.elvinntombert.myapplication.R
import com.example.elvinntombert.myapplication.model.Event
import kotlinx.android.synthetic.main.item_card.view.*

class EventItem(val event: Event): AbstractItem<EventItem, EventItem.EventViewHolder>(){

    override fun getType(): Int {
        return R.id.titleTextView
    }

    override fun getViewHolder(itemView: View?): EventViewHolder {
        return EventViewHolder(itemView)
    }

    override fun getLayoutRes(): Int {
        return R.layout.item_card
    }

    // Cellule = vue affiché dans le RecyclerView
    // Maximum on aura environ une dizaine d'instance de ViewHolder en mémoire
    class EventViewHolder(itemView: View?): FastAdapter.ViewHolder<EventItem>(itemView){
        override fun unbindView(item: EventItem?) {
            itemView.titleTextView.text = null
            itemView.subTitleTextView.text = null
            itemView.hourTextView.text = null
            itemView.priceTextView.text = null
        }

        override fun bindView(item: EventItem?, payloads: MutableList<Any>?) {
            val event = item?.event // Event?
            itemView.titleTextView.text = event?.title
            itemView.subTitleTextView.text = event?.address
            itemView.hourTextView.text = event?.date
            itemView.priceTextView.text = event?.price
        }

    }
}