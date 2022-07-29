package com.example.countryflags

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.countryflags.databinding.FragmentCountryDetailsBinding

class CountryDetailsFragment : Fragment() {
    companion object{
        const val COUNTRY = "country"
    }
    private var _binding: FragmentCountryDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var country:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            country = it.getString(COUNTRY).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCountryDetailsBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var uri = "@drawable/" + country.lowercase()
        var image = resources.getIdentifier(uri,null,activity?.packageName)
        val res = resources.getDrawable(image)
        binding.flagImage.setImageDrawable(res)

    }
}