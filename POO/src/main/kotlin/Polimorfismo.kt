package org.example

/*
* Polimorfismo: Permite que elementos de distintas clases pueden ser tratadas de manera uniforme
*
*/

fun main(){
    val dog = Dog()
    val cat = Cat()

    println(dog.makeSound())
    println(cat.makeSound())
}

open class Animal{
    open fun makeSound(){
        println("The animal make a sound")
    }
}

class Dog: Animal(){
    override fun makeSound() {
        println("The dog barks")
    }
}

class Cat: Animal(){
    override fun makeSound() {
        //El super. hace primero lo de la clase padre y luego lo que se sobreescribió
        super.makeSound()
        println("The cat meaws")
    }
}
