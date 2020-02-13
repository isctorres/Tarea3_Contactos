package com.example.contactos

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_ver_contacto.*;

class VerContacto : AppCompatActivity(), View.OnClickListener {

    var opc:String = ""
    val arContactos = arrayOf<Contacto>(
        Contacto("Rosa Pérez", "Secretaria", "SHCP", "Ocampo No. 234","Celaya, Gto.","rosa@gmail.com","4611238907"),
        Contacto("Julián Arreguín", "Programador", "Intel", "Av. del Bosque No. 1001","Zapopan, Jal","jualian@intel.mx","3316450000"),
        Contacto("Susy Ramírez", "Diseñadora", "Tec. Diseño de Modas", "Ocampo No. 274","Irapuato, Gto.","itedim96@hotmail.com","4626261392")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_contacto)

        btnEmail.setOnClickListener(this)
        btnLlamar.setOnClickListener(this)

        val intContacto = this.intent
        opc = intContacto.getStringExtra("IDCONTACTO")
        when(opc){
            "0"-> verContacto(0)
            "1"-> verContacto(1)
            "2"-> verContacto(2)
        }
    }

    private fun verContacto(i: Int) {

        var objContacto =arContactos.get(i)

        txtNombre.text = objContacto.nombre
        txtOcupacion.text = "Ocupación: " + objContacto.ocupacion
        txtTrabajo.text = "Trabaja en: " + objContacto.trabajo
        txtDomicilio.text = "Domicilio: " + objContacto.domicilio
        txtCiudad.text = "Ciudad: " + objContacto.ciudad
        txtCorreo.text = "Correo: " + objContacto.correo
        txtTelefono.text = "Tel: " + objContacto.telefono
    }

    override fun onClick(v: View?) {
        when( v?.id){
            R.id.btnEmail->enviarCorreo()
            R.id.btnLlamar->llamarContacto()
        }
    }

    private fun llamarContacto() {
        val intLlamar = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:"+arContactos.get(opc.toInt()).telefono)
        }
        startActivity(intLlamar)
    }

    private fun enviarCorreo() {
        val intCorreo = Intent(Intent.ACTION_SEND)
        intCorreo.data = Uri.parse("mailto:")
        intCorreo.type = "text/plain"
        intCorreo.putExtra(Intent.EXTRA_EMAIL, arrayOf(arContactos.get(opc.toInt()).correo))
        intCorreo.putExtra(Intent.EXTRA_SUBJECT,"Asunto")
        intCorreo.putExtra(Intent.EXTRA_TEXT,"Mensaje")
        startActivity(intCorreo)
    }
}
