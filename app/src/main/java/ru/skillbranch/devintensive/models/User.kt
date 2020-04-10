package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
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

    @Override
    fun equals(b: User, any: Any? = null):Boolean {
        return  when (any) {
            is Date ->  ((this.firstName == b.firstName) and (this.lastName == b.lastName) and (this.avatar == b.avatar) and (this.rating == b.rating)
                            and (this.respect == b.respect) and (this.isOnline == b.isOnline))

            else ->     ((this.firstName == b.firstName) and (this.lastName == b.lastName) and (this.avatar == b.avatar) and (this.rating == b.rating)
                            and (this.respect == b.respect) and (this.lastVisit == b.lastVisit) and (this.isOnline == b.isOnline))
            }
        }

    companion object Factory {
        private var last_id = -1

        fun makeUser (fullNane: String?): User{
            last_id++
            val (firstName, lastName) = Utils.parseFullName(fullNane)
            return when {
               (firstName == null) and (lastName == null) -> User(id = "$last_id")
               lastName == null -> User(id = "$last_id",firstName = firstName,lastName = "Kanor")
               else ->  User(id = "$last_id", firstName = firstName, lastName = lastName)
            }

        }
    }
}

/*TODO
    Реализуй паттерн Builder для класса User.
    User.Builder().id(s)
    .firstName(s)
    .lastName(s)
    .avatar(s)
    .rating(n)
    .respect(n)
    .lastVisit(d)
    .isOnline(b)
    .build() должен вернуть объект User
 */


