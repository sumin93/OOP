package corporation

fun main() {
    val assistant: Worker = Assistant("Helen", 20)
    val consultant: Worker = Consultant("John")
    val director: Worker = Director("Andrey", 22)
    val accountant = Accountant("Christian", 30)
    val workers = listOf(assistant, consultant, director, accountant)
    for (worker in workers) {
        worker.work()
    }
}
