package ru.skillbranch.devintensive.utils

import java.util.*

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
        if((lastName != " ") and (lastName != null)) {
            initials += lastName?.get(0)?.toUpperCase().toString()
        }
        return initials
    }

    fun transliteration(payload: String, divider:String = " "): String{
        var str = ""
        var chars = ""
        for (i in payload.indices) {
            chars = when (payload[i].toLowerCase()) {
                'а' -> "a"
                'б' -> "b"
                'в' -> "v"
                'г' -> "g"
                'д' -> "d"
                'е' -> "e"
                'ё' -> "e"
                'ж' -> "zh"
                'з' -> "z"
                'и' -> "i"
                'й' -> "i"
                'к' -> "k"
                'л' -> "l"
                'м' -> "m"
                'н' -> "n"
                'о' -> "o"
                'п' -> "p"
                'р' -> "r"
                'с' -> "s"
                'т' -> "t"
                'у' -> "u"
                'ф' -> "f"
                'х' -> "h"
                'ц' -> "c"
                'ч' -> "ch"
                'ш' -> "sh"
                'щ' -> "sh'"
                'ъ' -> ""
                'ы' -> "i"
                'ь' -> ""
                'э' -> "e"
                'ю' -> "yu"
                'я' -> "ya"
                ' ' -> divider
                else -> payload[i].toString()
            }
            if (payload[i].isUpperCase()) str += chars.capitalize()
            else str += chars
        }
        return str
    }

}

/*
    Реализуй метод Utils.parseFullName(fullName) принимающий в качестве аргумента полное имя пользователя (null, пустую строку) и возвращающий пару значений Pair(firstName, lastName) при невозможности распарсить полное имя или его часть вернуть null null/"firstName" null
    Пример:
    Utils.parseFullName(null) //null null
    Utils.parseFullName("") //null null
    Utils.parseFullName(" ") //null null
    Utils.parseFullName("John") //John null
 */
/*
    Реализуй метод Utils.toInitials(firstName lastName) принимающий в качестве аргументов имя и фамилию пользователя (null, пустую строку) и возвращающий строку с первыми буквами имени и фамилии в верхнем регистре (если один из аргументов null то вернуть один инициал, если оба аргумента null вернуть null)
    Пример:
    Utils.toInitials("john" ,"doe") //JD
    Utils.toInitials("John", null) //J
    Utils.toInitials(null, null) //null
    Utils.toInitials(" ", "") //null
*/
/*
    Реализуй метод Utils.transliteration(payload divider) принимающий в качестве аргумента строку (divider по умолчанию " ") и возвращающий преобразованную строку из латинских символов, словарь символов соответствия алфовитов доступен в ресурсах к заданию
    Пример:
    Utils.transliteration("Женя Стереотипов") //Zhenya Stereotipov
    Utils.transliteration("Amazing Петр","_") //Amazing_Petr
 */


































