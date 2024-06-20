package uz.isystem.presenrtation.main.home

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.isystem.presenrtation.R
import uz.isystem.presenrtation.base.BaseFragment
import uz.isystem.presenrtation.databinding.PageHomeBinding

class HomePage : BaseFragment(R.layout.page_home){

    private val binding by viewBinding(PageHomeBinding::bind)
    override fun onViewCreate(view: View, savedInstanceState: Bundle?) {

    }
}
