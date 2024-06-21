package corporation

enum class OperationCode(val title: String) {
    EXIT("Exit"),
    REGISTER_NEW_ITEM("Register new item"),
    SAVE_CHANGES("Save changes"),
    SHOW_ALL_CARDS("Show all cards")
}
