package uz.isystem.presenrtation.search

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.isystem.presenrtation.R
import uz.isystem.presenrtation.base.BaseFragment
import uz.isystem.presenrtation.databinding.ScreenSearchBinding

class SearchScreen : BaseFragment(R.layout.screen_search) {

    private val binding by viewBinding(ScreenSearchBinding::bind)
    private val viewModel: SearchViewModel by viewModels()
    private val adapter by lazy { SearchAdapter() }
    override fun onViewCreate(view: View, savedInstanceState: Bundle?) {

        setAdapter()
        sendRequest()
        observe()

    }

    private fun setAdapter() {
        binding.recyclerView.adapter = adapter
    }

    private fun observe() {
        viewModel.successResponse.observe(viewLifecycleOwner) {
            adapter.setData(it!!.tickets_offers)
        }

        viewModel.errorResponseEvery.observe(viewLifecycleOwner) {

            Log.d("TAGError", "observe: $it")

        }
    }

    private fun sendRequest() {
        viewModel.getTicketOffer()
    }
}
