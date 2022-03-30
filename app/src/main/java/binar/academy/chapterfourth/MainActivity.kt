package binar.academy.chapterfourth

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnDialogStandart = findViewById(R.id.alert_standart_button)
        btnDialogAction = findViewById(R.id.alert_action_button)
        btnDialogLayout = findViewById(R.id.alert_layout_button)

        btnDialogStandart.setOnClickListener {
            dialogStandart()
        }
        btnDialogAction.setOnClickListener {
            dialogAction()
        }
        btnDialogLayout.setOnClickListener {
            dialogLayout()
        }
    }

    private fun dialogStandart() {
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
        dialog.setPositiveButton("Positive Button"){dialogInterface, p1 ->
            Snackbar.make(findViewById(R.id.parentlayout),"Positive Button CLicked",Snackbar.LENGTH_LONG).show()
        }
        dialog.setNegativeButton("Negative Button"){dialogInterface, p1->
            Toast.makeText(this,"Negative Button CLicked",Toast.LENGTH_LONG).show()
        }
        dialog.setNeutralButton("Neutral Button"){dialogInterface, p1->
            Toast.makeText(this,"Neutral Button CLicked",Toast.LENGTH_LONG).show()
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
            Toast.makeText(this,"Custom Dialog Closed",Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }
        dialog.show()
    }
}