package corporation

import kotlin.random.Random

class Consultant(
    name: String,
    age: Int = 0
): Worker(name, age) {

    override fun work() {
        serveCustomers()
    }

    fun serveCustomers(): Int {
        val count = Random.nextInt(0, 100)
        repeat(count) {
            print("The customer is served... ")
        }
        println("\n")
        return count
    }

    fun sayHello() {
        print("Hi! My name is $name.")
        if (age > 0) {
            print(" I'm $age years old.\n")
        }
    }
}
