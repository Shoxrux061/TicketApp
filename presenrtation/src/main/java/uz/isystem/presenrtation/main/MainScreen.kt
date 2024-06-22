package uz.isystem.presenrtation.main

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.isystem.presenrtation.R
import uz.isystem.presenrtation.base.BaseFragment
import uz.isystem.presenrtation.databinding.ScreenMainBinding

class MainScreen : BaseFragment(R.layout.screen_main), ViewPagerInteractionListener {

    private val binding by viewBinding(ScreenMainBinding::bind)
    private var doubleBackToExitPressedOnce = false
    override fun onViewCreate(view: View, savedInstanceState: Bundle?) {

        setPager()
        onBackPressed()
    }

    private fun setPager() {
        val adapter = MainAdapter(childFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        binding.viewPager.isUserInputEnabled = false
        binding.bottomNavigation.background = null

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.ticketsID -> {
                    binding.viewPager.setCurrentItem(0, true)
                }

                R.id.hotelsID -> {
                    binding.viewPager.setCurrentItem(1, true)
                }

                R.id.locationID -> {
                    binding.viewPager.setCurrentItem(2, true)
                }

                R.id.notifID -> {
                    binding.viewPager.setCurrentItem(3, true)
                }

                else -> {
                    binding.viewPager.setCurrentItem(4, true)
                }
            }
            return@setOnItemSelectedListener true
        }

    }

    private fun onBackPressed() {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    val currentItem = binding.viewPager.currentItem
                    if (currentItem > 0) {
                        binding.viewPager.currentItem--
                    } else {
                        if (doubleBackToExitPressedOnce) {
                            requireActivity().finish()
                            return
                        }

                        doubleBackToExitPressedOnce = true
                        Toast.makeText(requireContext(), "Нажмите еще раз", Toast.LENGTH_SHORT)
                            .show()

                        Handler().postDelayed({
                            doubleBackToExitPressedOnce = false
                        }, 2000)
                    }
                }
            })
    }

    override fun onPageChangeRequested() {
        binding.viewPager.currentItem = 0
        binding.bottomNavigation.selectedItemId = R.id.ticketsID
    }
}

