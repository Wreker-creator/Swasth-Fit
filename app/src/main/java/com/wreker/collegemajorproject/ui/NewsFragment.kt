package com.wreker.collegemajorproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.wreker.collegemajorproject.MainActivity
import com.wreker.collegemajorproject.R
import com.wreker.collegemajorproject.databinding.FragmentNewsBinding
import com.wreker.collegemajorproject.epoxy.NewsListItemEpoxyController
import com.wreker.collegemajorproject.viewModel.SwasthFitViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class NewsFragment : Fragment(R.layout.fragment_news) {

    private var _binding : FragmentNewsBinding?=null
    private val binding get() = _binding!!

    private val epoxyController = NewsListItemEpoxyController()
    private lateinit var viewModel : SwasthFitViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewsBinding.bind(view)
        viewModel = (activity as MainActivity).viewModel1


        lifecycleScope.launch {
            viewModel.flow.collectLatest {
                epoxyController.submitData(it)
            }
        }

        binding.epoxyRecyclerView.setControllerAndBuildModels(epoxyController)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}