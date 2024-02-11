package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var numeroIng: Int?

    println("Bienvenido a la calculadora de números primos")
    println("Ingresa un número y descubre si es número primo")

    numeroIng = readln().toInt()

    if (checker(numeroIng)) {
        println("$numeroIng es un número primo.")
    } else {
        println("$numeroIng no es un número primo.")
    }

}

fun checker(numero: Int): Boolean{
    if (numero <= 1){
        return false
    }
    var esPrimo = true

    for(i in 2 until numero){
        if (numero % i == 0){
            esPrimo = false
            break
        }
    }
    return esPrimo
}