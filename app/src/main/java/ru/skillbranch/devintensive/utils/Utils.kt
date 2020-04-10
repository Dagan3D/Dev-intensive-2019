package ru.skillbranch.devintensive.utils

object Utils{
    fun parseFullName(fullName: String?): Pair<String?, String?>{
        val parts : List<String>? = fullName?.trimIndent()?.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        return if (firstName != "") Pair(firstName, lastName)
        else Pair(null, null)
    }

    fun toInitials(firstName: String?, lastName: String?): String?{
        var initials: String?
            when (firstName){
            null    -> return null
            " "     -> return null
            ""      -> return null
            else    -> initials = firstName[0].toUpperCase().toString()
        }
        if((lastName != null)and(lastName != " ") and (lastName != null)) {
            initials += lastName?.get(0)?.toUpperCase().toString()
        }
        return initials
    }
}

/*TODO
    Реализуй метод Utils.transliteration(payload divider) принимающий в качестве аргумента строку (divider по умолчанию " ") и возвращающий преобразованную строку из латинских символов, словарь символов соответствия алфовитов доступен в ресурсах к заданию
    Пример:
    Utils.transliteration("Женя Стереотипов") //Zhenya Stereotipov
    Utils.transliteration("Amazing Петр","_") //Amazing_Petr
 */

/*
    Реализуй метод Utils.toInitials(firstName lastName) принимающий в качестве аргументов имя и фамилию пользователя (null, пустую строку) и возвращающий строку с первыми буквами имени и фамилии в верхнем регистре (если один из аргументов null то вернуть один инициал, если оба аргумента null вернуть null)
    Пример:
    Utils.toInitials("john" ,"doe") //JD
    Utils.toInitials("John", null) //J
    Utils.toInitials(null, null) //null
    Utils.toInitials(" ", "") //null
*/