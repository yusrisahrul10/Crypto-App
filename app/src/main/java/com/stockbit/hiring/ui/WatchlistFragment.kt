package com.stockbit.hiring.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.stockbit.hiring.databinding.FragmentWatchlistBinding
import com.stockbit.hiring.ui.adapter.CryptoAdapter
import com.stockbit.remote.state.CryptoState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WatchlistFragment : Fragment() {

    private val viewModel: WatchlistViewModel by viewModels()

    private val binding: FragmentWatchlistBinding by lazy {
        FragmentWatchlistBinding.inflate(layoutInflater)
    }

    private val cryptoAdapter: CryptoAdapter by lazy {
        CryptoAdapter(requireContext())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initViewModel()
        initData()
    }

    private fun initData() {
        viewModel.getListCrypto()
    }

    private fun initViewModel() {
        viewModel.state.observe(viewLifecycleOwner, {
            when (it) {
                is CryptoState.Loading -> isLoading(true)
                is CryptoState.Result -> isLoading(false)
                is CryptoState.Error -> showError()
            }
        })
        viewModel.data.observe(viewLifecycleOwner, Observer(cryptoAdapter::submitList))
    }

    private fun initView() {
        with(binding) {
            rvCrypto.also {
                it.adapter = cryptoAdapter
                it.layoutManager = LinearLayoutManager(
                    requireContext(), LinearLayoutManager.VERTICAL ,false)
            }

            swipeRefresh.setOnRefreshListener {
                swipeRefresh.isRefreshing = true
                viewModel.getListCrypto()
            }
        }
    }

    private fun isLoading(loading: Boolean) {
        with(binding) {
            if (loading) {
                if (cryptoAdapter.currentList.isNullOrEmpty()) {
                    rvCrypto.visibility = View.INVISIBLE
                    progressBar.visibility = View.VISIBLE
                } else {
                    rvCrypto.visibility = View.VISIBLE
                    progressBar.visibility = View.INVISIBLE
                }
            } else {
                rvCrypto.visibility = View.VISIBLE
                progressBar.visibility = View.INVISIBLE
                swipeRefresh.isRefreshing = false
            }
        }
    }

    private fun showError() {
        binding.swipeRefresh.isRefreshing = false
        Toast.makeText(requireContext(), "Error. Please Try Again", Toast.LENGTH_SHORT).show()
    }


}