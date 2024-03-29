package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
enum class Choice {
    PIEDRA,
    PAPEL,
    TIJERA,
    SIN_ELECCION
}

enum class Winner {
    USUARIO,
    COMPUTADORA,
    EMPATE
}


fun main(){
    var computerChoice = Choice.SIN_ELECCION
    var playerChoice = Choice.SIN_ELECCION

    println("Por favor selecciona una opcion:")
    println("1. Piedra")
    println("2. Papel")
    println("3. Tijera")

    var choiceInput = readln().toIntOrNull()
    var isValidInput : Boolean = choiceInput != null && choiceInput in 1..3

    while(!isValidInput){
        println("Entrada no valida. Por favor ingresa solo numeros del 1 al 3")
        println("Ingresa el numero correspondiente a tu eleccion (1,2,3)")
        choiceInput = readln().toIntOrNull()
        isValidInput = choiceInput != null && choiceInput in 1..3
    }

    playerChoice = when(choiceInput) {
        1 -> Choice.PIEDRA
        2 -> Choice.PAPEL
        3 -> Choice.TIJERA
        else -> Choice.SIN_ELECCION
    }
    println("Tu eleccion es $playerChoice")

    if(playerChoice == Choice.SIN_ELECCION){
        println("Entrada no valida. Por favor ingresa solo numeros del 1 al 3")
        return
    }
    val randomNumber = (1..3).random()
    computerChoice = when (randomNumber){
        1 -> Choice.PIEDRA
        2 -> Choice. PAPEL
        3 -> Choice. TIJERA
        else -> Choice.SIN_ELECCION
    }
    println("La computadora selecciono : $computerChoice")
    val winner = when {
        playerChoice == computerChoice -> Winner.EMPATE
        playerChoice == Choice.PIEDRA && computerChoice == Choice.TIJERA -> Winner.USUARIO
        playerChoice == Choice.PAPEL && computerChoice == Choice.PIEDRA -> Winner.USUARIO
        playerChoice == Choice.TIJERA && computerChoice == Choice.PAPEL -> Winner.USUARIO
        else -> Winner.COMPUTADORA
    }
    println("El ganador es: $winner")
}