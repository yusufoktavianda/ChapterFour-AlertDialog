package binar.academy.chapterfourth

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.DialogFragment
import com.google.android.material.snackbar.Snackbar

class AlertDialogFragment : DialogFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.alert_dialog_fragment,container,false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnAlertDialogFragment = view.findViewById<Button>(R.id.button_alert_dialog_fragment)
        val editTextFragment = view.findViewById<EditText>(R.id.name_fragment_edittext)
        val layout_parent = view.findViewById<ConstraintLayout>(R.id.parentlayout)
        btnAlertDialogFragment.setOnClickListener {
            val name = editTextFragment.text.toString().trim()
            Toast.makeText(requireContext(),name,Toast.LENGTH_LONG).show()
//            Snackbar.make(requireView(R.layout.activity_main),name,Snackbar.LENGTH_LONG).show()
//            Log.d(name, "dialogfragment")
//            Snackbar.make(view.findViewById(android.R.id.content), name, Snackbar.LENGTH_LONG).show();
            dialog?.dismiss()
        }
    }
}