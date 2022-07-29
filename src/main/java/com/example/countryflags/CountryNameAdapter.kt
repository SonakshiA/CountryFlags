package com.example.countryflags

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

// the adapter that inflates view holders to the recycler view
class CountryNameAdapter(context: Context) :
    RecyclerView.Adapter<CountryNameAdapter.CountryViewHolder>() {

    private val countryNames:List<String>

    init{
        val names = context.resources.getStringArray(R.array.countries).toList()
        countryNames = names.sorted()
    }

    class CountryViewHolder(val view : View):RecyclerView.ViewHolder(view){
        val button =  view.findViewById<Button>(R.id.button_item)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return CountryViewHolder(layout)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
       val item = countryNames[position]
       holder.button.text = item

        //OnClickViewListener for each button (country name)
        holder.button.setOnClickListener{
            val action = CountryNameFragmentDirections.actionCountryNameFragmentToCountryDetailsFragment(country =  holder.button.text.toString())
            holder.view.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return countryNames.size
    }

}