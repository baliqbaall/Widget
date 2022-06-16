package com.example.widget

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.widget.databinding.ActivityWidgetBinding
import com.google.android.material.snackbar.Snackbar

  private lateinit var binding: ActivityWidgetBinding
class Widget : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inisialisasi binding
          binding = ActivityWidgetBinding.inflate(layoutInflater)

        //panggil layout menggunakan binding.root
          setContentView(binding.root)

        binding.btnToast.setOnClickListener{
            Toast.makeText(this,"Ini adalah Toast",Toast.LENGTH_SHORT).show()
        }
        binding.btnSnackbar.setOnClickListener {
         Snackbar.make(it, "Ini Adalah Snackbar", Snackbar.LENGTH_SHORT).show()
        }
        binding.btnAlert.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Message")
                setMessage("Ini Adalah Alert")

                setPositiveButton("OK"){ dialog, _ ->
                   Toast.makeText(applicationContext,"Anda Klik OK", Toast.LENGTH_SHORT).show()
                   dialog.dismiss()
                 }

                 setNegativeButton("Back"){dialog, _ ->
                    Toast.makeText(applicationContext,"Anda Klik Back",Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                 }
            }.show()
        }
        binding.btnCustomDialog.setOnClickListener {
            Dialog(this).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(false)
                setContentView(R.layout.custom_dialog)

                val btnBatal = this.findViewById<Button>(R.id.btnBatal)
                val btnLanjut = this.findViewById<Button>(R.id.btnLanjut)

                btnBatal.setOnClickListener{
                    Toast.makeText(applicationContext,"Anda Klik Batal", Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }

                btnLanjut.setOnClickListener {
                    Toast.makeText(applicationContext, "Anda Klik Lanjut", Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }
            }.show()
        }
    }
}