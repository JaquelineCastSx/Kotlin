package org.example

/*
* Encapsulamiento: ocultar el estado interno de una clase o un objeto. solo permite el acceso a traves de metodos específicos
* */

fun main(){
    var person = Person()
    person.setName("Pablo")
    person.setAge(20)
    println(person.getName())
    println(person.getAge())
}

class Person(){
    private var name: String = ""
    private var age: Int = 0

    fun getName(): String{
        return this.name
    }
    fun setName(name: String){
        this.name = name
    }

    fun getAge(): Int{
        return this.age
    }
    fun setAge(age: Int){
        this.age = age
    }

}