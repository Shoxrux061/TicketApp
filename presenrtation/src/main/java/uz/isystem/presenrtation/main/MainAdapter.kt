package uz.isystem.presenrtation.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.isystem.presenrtation.main.home.HomePage
import uz.isystem.presenrtation.main.other.OtherPage

class MainAdapter(fragmentManager: FragmentManager, ls : Lifecycle) : FragmentStateAdapter(fragmentManager,ls) {
    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment = when(position) {
        0 -> HomePage()
        else -> OtherPage()
    }
}