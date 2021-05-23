package com.example.chuyewyee.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chuyewyee.R

class CountryAdapter(private var dataSet: List<Country>) :
        RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textView: TextView

            init {
                // Define click listener for the ViewHolder's View.
                textView = view.findViewById(R.id.country_name)
            }
        }

        fun updateList(list: List<Country>){
            dataSet = list
            notifyDataSetChanged()
        }

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            // Create a new view, which defines the UI of the list item
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.country_item, viewGroup, false)

            return ViewHolder(view)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

            // Get element from your at this position and replace the
            // contents of the view with that element
            val country : Country = dataSet[position]
            viewHolder.textView.text = country.name
        }

        // Return the size of your (invoked by the layout manager)
        override fun getItemCount() = dataSet.size

        }

