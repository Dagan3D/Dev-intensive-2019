package ru.skillbranch.devintensive.utils

import ru.skillbranch.devintensive.models.Bender

object Utils{
    /*
    Принимает в качестве аргумента полное имя пользователя (null, пустую строку) и возвращающий пару значений Pair(firstName, lastName)
    при невозможности распарсить полное имя или его часть вернуть null null / "firstName" null
    Пример:
    Utils.parseFullName(null) //null null
    Utils.parseFullName("") //null null
    Utils.parseFullName(" ") //null null
    Utils.parseFullName("John") //John null
 */
    fun parseFullName(fullName: String?): Pair<String?, String?>{
        val parts : List<String>? = fullName?.trimIndent()?.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        return if (firstName != "") Pair(firstName, lastName)
        else Pair(null, null)
    }

    /*  Принимает в качестве аргументов имя и фамилию пользователя (null, пустую строку) и возвращающий строку с первыми буквами имени и фамилии в верхнем регистре
        (если один из аргументов null то вернуть один инициал, если оба аргумента null вернуть null)
        Пример:
        Utils.toInitials("john" ,"doe") //JD
        Utils.toInitials("John", null) //J
        Utils.toInitials(null, null) //null
        Utils.toInitials(" ", "") //null
    */
    fun toInitials(firstName: String?, lastName: String?): String?{
        var initials: String?
        val fName = firstName?.trim()
        val lName = lastName?.trim()
        println("$fName $lName")
        if((fName != " ") and (fName != null) and (fName != "")) {
            initials = fName?.get(0)?.toUpperCase().toString()

            if((lName != " ") and (lName != null) and (lName != " ")) initials += lName?.get(0)?.toUpperCase().toString()

        } else if((lName != " ") and (lName != null) and (lName != "")) {

            initials = lName?.get(0)?.toUpperCase().toString()

        } else {
            initials = null
        }
                return initials
    }

    /*
        Принимает в качестве аргумента строку (divider по умолчанию " ") и возвращающий преобразованную строку из латинских символов
        Пример:
        Utils.transliteration("Женя Стереотипов") //Zhenya Stereotipov
        Utils.transliteration("Amazing Петр","_") //Amazing_Petr
     */
    fun transliteration(payload: String, divider:String = " "): String{
        var str = ""
        var chars: String
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
            str += if (payload[i].isUpperCase()) chars.capitalize()
            else chars
        }
        return str
    }

    /*Проверяет соотвтсвие строки переданой параметрам валидации
    NAME -> "Имя должно начинаться с заглавной буквы"
    PROFESSION -> "Профессия должна начинаться со строчной буквы"
    MATERIAL -> "Материал не должен содержать цифр"
    BDAY -> "Год моего рождения должен содержать только цифры"
    SERIAL -> "Серийный номер содержит только цифры, и их 7"
    IDLE -> //игнорировать валидацию
    */
    fun validation (string: String, typeQuestion: Bender.Question):Pair<Boolean, String?> {
        return when(typeQuestion){
            Bender.Question.NAME -> {
                if (!string.matches(Regex("""[A-Z].*"""))){
                    false to "Имя должно начинаться с заглавной буквы"
                } else {
                    true to null
                }
            }
            Bender.Question.PROFESSION -> {
                if (!string.matches(Regex("""[a-z].*"""))){
                    false to "Профессия должна начинаться со строчной буквы"
                } else {
                    true to null
                }
            }
            Bender.Question.MATERIAL -> {
                if (string.contains(Regex("""\d"""))){
                    false to "Материал не должен содержать цифр"
                } else {
                    true to null
                }
            }
            Bender.Question.BDAY -> {
                if (string.contains(Regex("""\D"""))){
                    false to "Год моего рождения должен содержать только цифры"
                } else {
                    true to null
                }
            }
            Bender.Question.SERIAL -> {
                if (!string.contains(Regex("""\d{7}"""))){
                    false to "Серийный номер содержит только цифры, и их 7"
                } else {
                    true to null
                }
            }
            Bender.Question.IDLE -> {
                    true to null
            }
        }
    }
}






































