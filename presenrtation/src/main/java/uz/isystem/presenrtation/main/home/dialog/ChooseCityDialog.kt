package uz.isystem.presenrtation.main.home.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import uz.isystem.presenrtation.R

class ChooseCityDialog : BottomSheetDialogFragment() {

    private lateinit var selectStambul:RelativeLayout
    private lateinit var selectSochi:RelativeLayout
    private lateinit var selectPhuket:RelativeLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_choose_city, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setView(view)

        listenActions()



    }

    private fun listenActions() {
        selectStambul.setOnClickListener {
        }
    }

    private fun setView(view:View) {
        selectStambul = view.findViewById(R.id.select_stambul)
        selectSochi = view.findViewById(R.id.select_sochi)
        selectPhuket = view.findViewById(R.id.select_phuket)
    }
}