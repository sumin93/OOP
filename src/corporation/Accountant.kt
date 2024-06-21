package corporation

import java.io.File

class Accountant(
    name: String,
    age: Int
) : Worker(name, age) {

    val items = mutableListOf<ProductCard>()
    val file = File("product_cards.txt")

    override fun work() {
        val operationCodes = OperationCode.entries
        while (true) {
            print("Enter the operation code. ")
            for ((index, code) in operationCodes.withIndex()) {
                print("$index - ${code.title}; ")
            }
            val operationIndex = readln().toInt()
            val operationCode = operationCodes[operationIndex]
            when (operationCode) {
                OperationCode.EXIT -> break
                OperationCode.REGISTER_NEW_ITEM -> registerNewItem()
                OperationCode.SAVE_CHANGES -> saveChanges()
                OperationCode.SHOW_ALL_CARDS -> loadProductCards()
            }
        }
    }

    fun saveChanges() {
        for (item in items) {
            file.appendText("${item.name}-${item.brand}-${item.price}-")
            when (item) {
                is ApplianceCard -> {
                    file.appendText("${item.wattage}-${ProductType.APPLIANCE}\n")
                }

                is FoodCard -> {
                    file.appendText("${item.caloric}-${ProductType.FOOD}\n")
                }

                is ShoeCard -> {
                    file.appendText("${item.size}-${ProductType.SHOE}\n")
                }
            }

        }
        items.clear()
    }

    fun loadProductCards() {
        val cards = mutableListOf<ProductCard>()
        val content = file.readText().trim()
        val cardsAsText = content.split("\n")
        for (card in cardsAsText) {
            val properties = card.split("-")
            val name = properties[0]
            val brand = properties[1]
            val price = properties[2].toInt()
            val type = ProductType.valueOf(properties.last())
            val productCard = when (type) {
                ProductType.FOOD -> {
                    val caloric = properties[3].toInt()
                    FoodCard(name, brand, price, caloric)
                }

                ProductType.APPLIANCE -> {
                    val wattage = properties[3].toInt()
                    ApplianceCard(name, brand, price, wattage)

                }

                ProductType.SHOE -> {
                    val size = properties[3].toFloat()
                    ShoeCard(name, brand, price, size)
                }
            }
            cards.add(productCard)
        }
        for (card in cards) {
            card.printInfo()
        }
    }

    fun registerNewItem() {
        val productTypes = ProductType.entries
        print("Enter the product type. ")
        for ((index, type) in productTypes.withIndex()) {
            print("$index - ${type.title}; ")
        }
        val productTypeIndex = readln().toInt()
        val productType = productTypes[productTypeIndex]
        print("Enter the product name: ")
        val productName = readln()
        print("Enter the product brand: ")
        val productBrand = readln()
        print("Enter the product price: ")
        val productPrice = readln().toInt()
        val card = when (productType) {
            ProductType.FOOD -> {
                print("Enter the caloric: ")
                val caloric = readln().toInt()
                FoodCard(
                    name = productName,
                    brand = productBrand,
                    price = productPrice,
                    caloric = caloric
                )
            }

            ProductType.APPLIANCE -> {
                print("Enter the wattage: ")
                val wattage = readln().toInt()
                ApplianceCard(
                    name = productName,
                    brand = productBrand,
                    price = productPrice,
                    wattage = wattage
                )
            }

            ProductType.SHOE -> {
                print("Enter the size: ")
                val size = readln().toFloat()
                ShoeCard(
                    name = productName,
                    brand = productBrand,
                    price = productPrice,
                    size = size
                )
            }
        }
        items.add(card)
    }
}
