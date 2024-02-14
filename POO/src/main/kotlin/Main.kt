package org.example
import java.util.UUID

/*Fabrica de vehiculos
Coches y motos
Modelo
Marcas
Metodos por vehiculo
* */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    try {
        val factory = Factory()
        val tesla = factory.produceCar("Tesla", "Model S") as Tesla
        val ferrari = factory.produceCar("Ferrari", "Enzo") as Ferrari
        val tesla2 = factory.produceCar("Tesla", "Model X") as Tesla
        val ferrari2 = factory.produceCar("Ferrari", "F8 Turbo") as Ferrari
        factory.addCar(tesla)
        factory.addCar(ferrari)
        factory.addCar(tesla2)
        factory.addCar(ferrari2)

        tesla.charged()
        ferrari.drift()
        ferrari.accelerate()

        val cars = factory.getAllCars()
        cars.forEach { c->
            println("The car is a ${c.brand} with model ${c.model} with VIN ${c.getVin()}")
        }

    }catch (e:Exception){
        println(e)
    }
}

abstract class Vehicle(val wheels: Int){
    fun stop(){
        println("The vehicle is stopped")
    }
    fun accelerate(){
        println("The vehicle is moving")
    }
    open fun brake(){
        println("The vehicle is braking with ${wheels} wheels")
    }
}

abstract class Car(val brand:String, val maxSpeed: Double, open val model:String):Vehicle(4){
    private val vin : UUID = UUID.randomUUID()

    fun openDoors(){
        println("Opening doors")
    }

    fun enableAC(){
        println("Enable AC")
    }
    fun getVin():UUID{
        return vin
    }
}

class Tesla(override val model: String):Car("Tesla", 300.0, "Model S"){
    fun autopilot(){
        println("Enable autopilot")
    }
    fun charged(){
        println("Is charging")
    }

    override fun brake() {
        super.brake()
        println("Recharging battery")
    }
}

class Ferrari(override val model: String):Car("Ferrari", 450.0, "Enzo"){
    fun turbo(){
        println("Turbo is on")
    }
    fun drift(){
        println("Making drift")
    }
}

class motorcycle(val brand: String, val maxSpeed: Double, val model: String): Vehicle(2){
    fun wheelie(){
        println("Making wheelie")
    }
}

class Factory{
    //Se pone mutable porque se va a agregar/remover elementos
    private val cars = mutableListOf<Car>()
    fun produceCar(brand:String, model: String):Car{
        val car = when(brand){
            "Tesla" -> Tesla(model)
            "Ferrari" -> Ferrari(model)
            else -> throw IllegalArgumentException("Brand not recognized")
        }
        return car
    }
    fun produceMotocycle(brand: String, model: String, maxSpeed: Double):motorcycle{
        return motorcycle(brand, maxSpeed, model)
    }

    fun addCar(car:Car) {
        cars.add(car)
    }
    fun removeCar(car:Car){
        cars.remove(car)
    }
    fun removeCarAt(index:Int){
        cars.removeAt(index)
    }
    fun getCarByBrand(brand:String):List<Car>{
        return cars.filter { it.brand == brand }
    }
    fun getAllCars():List<Car>{
        return cars
    }
}