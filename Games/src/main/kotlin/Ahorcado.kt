package org.example

fun main(){
    val words = listOf("gato","perro","elefante","leon","tigre","ballena","tiburon","nutria")
    val wordToGuess = words[words.indices.random()]
    val correctLetters = mutableListOf<Char>()
    val incorrectLetters = mutableListOf<Char>()
    var attempts = 5

    println("Bienvenido al juego del ahorcado")
    println("La palabra tiene ${wordToGuess.length} letras")

    while(attempts > 0){
        println("Palabra: ${hideWord(wordToGuess,correctLetters)}")
        println("Ingresa una letra")
        val letter = readlnOrNull()?.lowercase()?.firstOrNull()

        if(letter == null || !letter.isLetter()){
            println("Por favor, ingresa una letra valida")
            continue
        }

        if(correctLetters.contains(letter) || incorrectLetters.contains(letter)){
            println("Ya has intentado con esa letra")
            continue
        }

        if(wordToGuess.contains(letter)){
            correctLetters.add(letter)
            if(wordToGuess.all { c -> correctLetters.contains(c)}){
                println("Felicidades Has adivinado la palabra correctamente")
                println("La palabra era: $wordToGuess")
                break
            }
        }
        else{
            incorrectLetters.add(letter)
            attempts--
            println("Te has equivocado te quedan $attempts intentos")
            continue
        }
        println("Has perdido")
    }

}

//fun hideWord(word:String,correctLetters : List<Char>) : String{
//    val hiddenWord = StringBuilder()
//    for(char in word){
//        if(correctLetters.contains(char)){
//            hiddenWord.append(char)
//        }
//        else {
//            hiddenWord.append("_")
//        }
//        hiddenWord.append(" ")
//    }
//    return hiddenWord.toString().trim()
//}

fun hideWord(word:String,correctLetters:List<Char>) : String{
    return word.map { if(correctLetters.contains(it)) it else '_' }.joinToString(" ")
}