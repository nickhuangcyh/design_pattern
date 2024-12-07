package singletonpattern

import singletonpattern.source.DatabaseClient

fun main() {
    val db = DatabaseClient.getInstance()
    db.create("test", mapOf(Pair("test", "123")))
}