package com.example.chuyewyee.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chuyewyee.R
import com.example.chuyewyee.presentation.api.CountryApi
import com.example.chuyewyee.presentation.api.CountryListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CountryListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = CountryAdapter(arrayListOf(), ::onClickedCountry)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView =  view.findViewById(R.id.country_recyclerview)

        recyclerView.apply {
            layoutManager = LinearLayoutManager (context)
            adapter = this@CountryListFragment.adapter
        }

        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.worldbank.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: CountryApi = retrofit.create(CountryApi::class.java)

        CountryApi.getCountryList().enqueue(object : Callback<CountryListResponse> {
            override fun onFailure(
                call: Call<CountryListResponse>,
                t: Throwable
                ) {

                TODO("not implemented")
        }

            override fun onResponse(call: Call<CountryListResponse>, response: Response<CountryListResponse>) {
                if(response.isSuccessful && response.body() !=null ){
                    val CountryListResponse = response.body()
                }
            }

            })

        private fun onClickedCountry(country: Country): Unit? {
            findNavController().navigate(R.id.act)
        }


        val countryList = arrayListOf<Country>().apply {
            add(Country("France"))
            add(Country("Italie"))
            add(Country("Finlande"))
            add(Country("Suisse"))
        }
            adapter.updateList(countryList)
        }}


