package uz.isystem.presenrtation.main.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.isystem.presenrtation.R
import uz.isystem.presenrtation.base.BaseFragment
import uz.isystem.presenrtation.databinding.PageHomeBinding
import uz.isystem.presenrtation.main.home.dialog.ChooseCityDialog

class HomePage : BaseFragment(R.layout.page_home) {

    private val binding by viewBinding(PageHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels()
    private val adapter by lazy { HomeAdapter() }
    private var isFirst = true
    private lateinit var dialog: ChooseCityDialog

    override fun onViewCreate(view: View, savedInstanceState: Bundle?) {



        setDialog()
        if (isFirst) {
            sendRequest()
        }
        isFirst = false

        listenActions()
        setAdapter()
        observe()

    }

    private fun setDialog() {
        dialog = ChooseCityDialog()
    }

    private fun listenActions() {
        binding.fromEdt.setOnClickListener {
            dialog.show(childFragmentManager, "ChooseCity")

        }
    }

    private fun setAdapter() {
        binding.recyclerView.adapter = adapter
    }

    private fun sendRequest() {
        viewModel.getMusicalOffers()
    }

    private fun observe() {
        viewModel.successResponse.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = View.GONE
            binding.root.visibility = View.VISIBLE
            adapter.setData(it!!.offers)
        }

        viewModel.errorResponseEvery.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = View.GONE
            binding.root.visibility = View.VISIBLE
            Log.d("TAGError", "observe: $it")
        }
    }
}