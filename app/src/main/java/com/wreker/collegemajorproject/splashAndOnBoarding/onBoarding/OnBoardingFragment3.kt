package com.wreker.collegemajorproject.splashAndOnBoarding.onBoarding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.wreker.collegemajorproject.R
import com.wreker.collegemajorproject.databinding.FragmentOnBoarding1Binding
import com.wreker.collegemajorproject.databinding.FragmentOnBoarding3Binding

class OnBoardingFragment3 : Fragment(R.layout.fragment_on_boarding3){

    private var _binding : FragmentOnBoarding3Binding?=null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOnBoarding3Binding.bind(view)


        binding.btnNext.setOnClickListener{
            findNavController().navigate(R.id.action_viewPagerFragment_to_HomeFragment)
            onBoardingFinished()
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onBoardingFinished(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("finished", true)
        editor.apply()
    }

}