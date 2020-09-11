package com.vanr.starwarsplanet.ui.main.listOfResidents

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vanr.starwarsplanet.R
import io.reactivex.subjects.PublishSubject

class ResidentsAdapter: RecyclerView.Adapter<ResidentsAdapter.ResidentsViewHolder>() {

    val showResidentDetails: PublishSubject<String> = PublishSubject.create()

    lateinit var list: Array<String>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResidentsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ResidentsViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ResidentsViewHolder, position: Int) {
        val residentUrl: String = list[position]
        holder.bind(residentUrl)
    }

    fun setData(list: Array<String>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class ResidentsViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {
        private var residentUrl: TextView? = null

        init {
            residentUrl = itemView.findViewById(R.id.residentUrl)
        }

        fun bind(resident: String) {
            residentUrl?.text = resident
            itemView.setOnClickListener {
                showResidentDetails.onNext(resident)
            }
        }
    }
}