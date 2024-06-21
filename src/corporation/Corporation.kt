package corporation

import java.io.File

fun main() {
    val file = File("todo_list.txt")
//    while (true) {
//        print("Enter a new item or 0 to exit: ")
//        val item = readln()
//        if (item == "0") break
//        file.appendText("$item\n")
//    }
    val content = file.readText()
    println(content)
}
