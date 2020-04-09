package ru.skillbranch.devintensive.utils

object Utils{
    fun parseFullName(fullName: String?): Pair<String?, String?>{
        val parts : List<String>? = fullName?.trimIndent()?.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        return if (firstName != "") Pair(firstName, lastName)
        else Pair(null, null)
    }
}