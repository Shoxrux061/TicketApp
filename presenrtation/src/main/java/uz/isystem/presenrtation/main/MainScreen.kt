package uz.isystem.presenrtation.main

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.isystem.presenrtation.R
import uz.isystem.presenrtation.base.BaseFragment
import uz.isystem.presenrtation.databinding.ScreenMainBinding

class MainScreen : BaseFragment(R.layout.screen_main){

    private val binding by viewBinding(ScreenMainBinding::bind)
    override fun onViewCreate(view: View, savedInstanceState: Bundle?) {

    }
}

