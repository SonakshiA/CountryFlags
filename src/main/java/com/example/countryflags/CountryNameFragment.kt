package com.example.countryflags

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countryflags.databinding.FragmentCountryNameBinding


class CountryNameFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var _binding: FragmentCountryNameBinding? = null

    private val  binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCountryNameBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       recyclerView = binding.recyclerView
        recyclerView.adapter = CountryNameAdapter(this.requireContext())

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}