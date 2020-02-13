package com.example.contactos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*;

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imvContacto1.setOnClickListener(this)
        imvContacto2.setOnClickListener(this)
        imvContacto3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.imvContacto1->verContacto("0")
            R.id.imvContacto2->verContacto("1")
            R.id.imvContacto3->verContacto("2")
        }
    }

    private fun verContacto(i: String) {
        val intContacto = Intent(this,VerContacto::class.java)
        intContacto.putExtra("IDCONTACTO", i)
        startActivity(intContacto)
    }

}
