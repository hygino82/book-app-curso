package br.dev.hygino.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.dev.hygino.BookConstants.KEY.BOOK_ID
import br.dev.hygino.R
import br.dev.hygino.databinding.FragmentHomeBinding
import br.dev.hygino.ui.adapter.BookAdapter
import br.dev.hygino.ui.listener.BookListener
import br.dev.hygino.ui.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()
    private val adapter: BookAdapter = BookAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.recyclerviewBooks.layoutManager = LinearLayoutManager(context)
        binding.recyclerviewBooks.adapter = adapter

        attachListener()

        viewModel.getAllBooks()

        setObservers()

        return binding.root
    }

    private fun attachListener() {
        adapter.attachListener(object : BookListener {
            override fun onClick(id: Int) {
                val bundle = Bundle()
                bundle.putInt(BOOK_ID, id)
                findNavController().navigate(R.id.navigation_details,bundle)
            }
        })
    }

    private fun setObservers() {
        viewModel.books.observe(viewLifecycleOwner) {
            adapter.updateBooks(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}