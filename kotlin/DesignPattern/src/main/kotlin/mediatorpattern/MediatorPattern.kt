package mediatorpattern

import mediatorpattern.source.ChatRoomMediator
import mediatorpattern.source.ChatUser

fun main() {
    val chatMediator = ChatRoomMediator()

    val user1 = ChatUser(chatMediator, "Alice")
    val user2 = ChatUser(chatMediator, "Bob")
    val user3 = ChatUser(chatMediator, "Charlie")

    chatMediator.addUser(user1)
    chatMediator.addUser(user2)
    chatMediator.addUser(user3)

    user1.send("Hello, everyone!")
    user2.send("Hi, Alice!")
}