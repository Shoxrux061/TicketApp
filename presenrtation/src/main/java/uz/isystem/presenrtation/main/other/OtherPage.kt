package uz.isystem.presenrtation.main.other

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import uz.isystem.presenrtation.R
import uz.isystem.presenrtation.base.BaseFragment
import uz.isystem.presenrtation.main.MainScreen
import uz.isystem.presenrtation.main.ViewPagerInteractionListener

class OtherPage : BaseFragment(R.layout.page_other) {

    private lateinit var buttonBack: Button
    private var listener: ViewPagerInteractionListener? = null

    override fun onViewCreate(view: View, savedInstanceState: Bundle?) {
        buttonBack = view.findViewById(R.id.button_back)
        setActions()
    }


    private fun setActions() {
        buttonBack.setOnClickListener {
            listener?.onPageChangeRequested()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (parentFragment is ViewPagerInteractionListener) {
            listener = parentFragment as ViewPagerInteractionListener
        } else {
            throw RuntimeException("Parent fragment must implement ViewPagerInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}