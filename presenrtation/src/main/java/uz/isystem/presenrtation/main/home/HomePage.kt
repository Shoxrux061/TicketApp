package uz.isystem.presenrtation.main.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.isystem.presenrtation.R
import uz.isystem.presenrtation.base.BaseFragment
import uz.isystem.presenrtation.databinding.PageHomeBinding

class HomePage : BaseFragment(R.layout.page_home) {

    private val binding by viewBinding(PageHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels()
    private val adapter by lazy { HomeAdapter() }
    private var isFirst = true

    override fun onViewCreate(view: View, savedInstanceState: Bundle?) {
        if(isFirst) {
            sendRequest()
        }
        isFirst = false
        setAdapter()
        observe()

    }

    private fun setAdapter() {
        binding.recyclerView.adapter = adapter
    }

    private fun sendRequest() {
        viewModel.getMusicalOffers()
    }

    private fun observe() {
        viewModel.successResponse.observe(viewLifecycleOwner) {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
            adapter.setData(it!!.offers)
        }

        viewModel.errorResponseEvery.observe(viewLifecycleOwner) {
            Toast.makeText(context, "False", Toast.LENGTH_SHORT).show()
        }
    }
}