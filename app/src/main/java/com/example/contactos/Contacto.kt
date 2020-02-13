package com.example.contactos

class Contacto(nombre: String, ocupacion: String, trabajo: String, domicilio: String, ciudad: String, correo: String, telefono: String ) {
    var nombre: String = ""
    var ocupacion: String = ""
    var trabajo: String = ""
    var domicilio: String = ""
    var ciudad: String = ""
    var correo: String = ""
    var telefono: String = ""

    init {
        this.nombre = nombre
        this.ocupacion = ocupacion
        this.trabajo = trabajo
        this.domicilio = domicilio
        this.ciudad = ciudad
        this.correo = correo
        this.telefono = telefono
    }
}