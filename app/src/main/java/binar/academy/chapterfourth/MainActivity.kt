package binar.academy.chapterfourth

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var btnDialogStandart: Button
    private lateinit var btnDialogAction: Button
    private lateinit var btnDialogLayout: Button
    private lateinit var btnCloseLayout: Button
    private lateinit var snackActionButton: Button
    private lateinit var snackIndefiniteButton: Button
    private lateinit var btnDialogFragmentButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnDialogStandart = findViewById(R.id.alert_standart_button)
        btnDialogAction = findViewById(R.id.alert_action_button)
        btnDialogLayout = findViewById(R.id.alert_layout_button)
        snackActionButton = findViewById(R.id.snackbar_action_button)
        snackIndefiniteButton = findViewById(R.id.snackbar_indefinite_button)
        btnDialogFragmentButton = findViewById(R.id.alert_dialog_fragment_button)

        btnDialogStandart.setOnClickListener {
            dialogStandards()
        }
        btnDialogAction.setOnClickListener {
            dialogAction()
        }
        btnDialogLayout.setOnClickListener {
            dialogLayout()
        }
        snackActionButton.setOnClickListener {
            snackActionSample()
        }
        snackIndefiniteButton.setOnClickListener {
            snackIndefiniteSample()
        }
        btnDialogFragmentButton.setOnClickListener {
            alertDialogFragment()
        }
    }

    private fun dialogStandards() {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Dialog Cancelable")
        dialog.setMessage("Dialog Standart bisa ditutup dengan mengklik bagian luar dialog")
        dialog.setCancelable(true)
        dialog.show()
    }
    private fun dialogAction(){
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Dialog with Action Button")
        dialog.setMessage("Dialog with many action")
        dialog.setIcon(R.mipmap.ic_launcher)

        dialog.setCancelable(false)
        dialog.setPositiveButton("Positive Button"){ _, _ ->
            Snackbar.make(findViewById(R.id.parentlayout),"Positive Button CLicked",Snackbar.LENGTH_LONG).show()
        }
        dialog.setNegativeButton("Negative Button"){ _, _ ->
            Snackbar.make(findViewById(R.id.parentlayout),"Negative Button CLicked",Snackbar.LENGTH_LONG).show()
        }
        dialog.setNeutralButton("Neutral Button"){ _, _ ->
            Snackbar.make(findViewById(R.id.parentlayout),"Neutral Button CLicked",Snackbar.LENGTH_LONG).show()
        }
        dialog.show()
    }

    private fun dialogLayout(){
        val view = LayoutInflater.from(this).inflate(R.layout.custom_dialog_alert,null,false)
        btnCloseLayout = view.findViewById(R.id.close_layout_button)
        val dialogBuilder=AlertDialog.Builder(this)
        dialogBuilder.setView(view)

        val dialog = dialogBuilder.create()
        btnCloseLayout.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this,"Custom Dialog Closed",Toast.LENGTH_LONG).show()
        }
        dialog.show()
    }

    private fun snackActionSample(){
        Snackbar.make(findViewById(R.id.parentlayout),"Ini Snackbar dengan Action", Snackbar.LENGTH_LONG)
            .setAction("Text Action"){
                Toast.makeText(this, "Toast dari Action Snackbar",Toast.LENGTH_LONG).show()
            }
            .show()
    }

    private fun snackIndefiniteSample(){
        val snackBar = Snackbar.make(findViewById(R.id.parentlayout),"Ini snackbar Indefinite. Gak bakal pergi kalo gak klik Dismiss/ ada Snackbar lainnya", Snackbar.LENGTH_INDEFINITE)
        snackBar.setAction("Dismiiss"){
            snackBar.dismiss()
        }
        snackBar.show()
    }

    private fun alertDialogFragment(){
        val dialogFragment = AlertDialogFragment()
        dialogFragment.show(supportFragmentManager,"tag")
    }
}