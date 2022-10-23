package com.example.exerciciomodulo6

fun main() {

    val factory = VehicleFactory()
    val vehicleList: MutableList<Vehicle> = mutableListOf()

    for(i in 1..100){
        val Vehicle = factory.createVehicle(i % 2)
        vehicleList.add(Vehicle)
    }

    vehicleList.forEach{
            Vehicle ->
        println(Vehicle)
        Vehicle.ride()
        println(Vehicle)
        Vehicle.ride()
        Vehicle.brake()
        println(Vehicle)
    }
}

class VehicleFactory{
    fun createVehicle(type: Int) : Vehicle{
        return when(type){
            1 -> Car()
            else -> Motorcycle()
        }
    }
}

abstract class Vehicle{
    var velocity: Int = 0
    abstract var aceleration: Int

    abstract fun ride()
    abstract fun brake()
    fun vehicleVelocity(): Int = velocity + aceleration

    override fun toString() = "velocidade do veiculo: ${vehicleVelocity()}"
}

class Car: Vehicle(){
    override var aceleration = 15
    override fun ride(){
        this.velocity++
    }
    override fun brake() {
        this.velocity--
        if (velocity < 0)
            velocity = 0

    }
}
class Motorcycle: Vehicle(){
    override var aceleration = 10
    override fun ride(){
        this.velocity++
    }
    override fun brake(){
        this.velocity--
        if (velocity < 0)
            velocity = 0
    }
}
