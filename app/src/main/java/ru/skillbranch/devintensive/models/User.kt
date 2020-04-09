package ru.skillbranch.devintensive.models

import java.util.*

data class User (
    val id : String,
    var firstName : String?,
    var lastName : String?,
    var avatar : String?,
    var rating : Int = 0,
    var respect : Int = 0,
    var lastVisit : Date? = Date(),
    var isOnline : Boolean = false
) {

    constructor(id: String, firstName: String?, lastName: String?): this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )
    constructor(id: String): this(id, "Dan", "Kanor")

    fun printMe() = println("""
        firstName: $firstName
        lastName: $lastName
        avatar: $avatar
        rating: $rating
        respect: $respect
        lastVisit: $lastVisit
        isOnline: $isOnline        
    """.trimIndent())

    companion object Factory {
        private var last_id = -1

        fun makeUser (fullNane: String?): User{
            last_id++

            val parts : List<String>? = fullNane?.trimIndent()?.split(" ")

            val lastName = parts?.getOrNull(0)
            val firstName = parts?.getOrNull(1)

            return when {
                lastName == null    -> User(id = "$last_id")
                firstName == null   -> User(id = "$last_id")
                else ->  User(id = "$last_id", firstName = firstName, lastName = lastName)
            }

        }
    }
}



