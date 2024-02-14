package org.example
/*
* Abstraccion: muestran solo la informacion escencial y ocultan detalles innecesarios
* Las interfaces defines que vas a hacer, no como.
* Las clases abstractas te dicen que y como hacerlo.
* */


fun main(){
    var circle = Circle(4.0)
    var rectangle = Rectangle(3.0,6.0)

    println(circle.calculateArea())
    println(rectangle.calculateArea())
}

abstract class Shape{
    abstract fun calculateArea():Double
}

class Circle(private val radius: Double):Shape(){
    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }
}

class Rectangle(private val width: Double, private val height: Double):Shape(){
    override fun calculateArea(): Double {
        return width*height
    }
}