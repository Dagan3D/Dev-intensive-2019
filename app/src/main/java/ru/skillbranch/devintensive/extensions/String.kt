/*package ru.skillbranch.devintensive.extensions

fun String.truncate(number: Int = 16):String{
    var strok: String = this.trim()
    var str: String = ""
    if (strok.length > number) {
        for (i in 0 until number) {
            if (!((i == (number - 1)) and (strok[i] == ' ')))
                str += strok[i]
        }
        str = str.trim()
        str += "..."
        //println(this.trim())
    } else {
        str = strok
    }
    return str

}

fun String.stripHtml(): String{
    var str = ""
    println(this.split("""<[^>]*>*|\s+""".toRegex()))
    for (i in this.split("""<[^>]*>|(\s+)""".toRegex())){
        str += i.trim()
        str += " "
    }
    return str.trim().replace("""[&<>'"]""".toRegex(), "")
}
*/
/*
    Реализуй extension усекающий исходную строку до указанного числа символов (по умолчанию 16) и возвращающий усеченную строку с заполнителем "..." (если строка была усечена)
    если последний символ усеченной строки является пробелом - удалить его и добавить заполнитель
    Пример:
    "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate() //Bender Bending R...
    "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15) //Bender Bending...
    "A     ".truncate(3) //A
*/

/*
    Реализуй extension позволяющий очистить строку от html тегов и html escape последовательностей ("& < > ' ""),
    а так же удалить пустые символы (пробелы) между словами если их больше 1.
    Необходимо вернуть модифицированную строку
    Пример:
    "<p class="title">Образовательное IT-сообщество Skill Branch</p>".stripHtml() //Образовательное IT-сообщество Skill Branch
    "<p>Образовательное       IT-сообщество Skill Branch</p>".stripHtml() //Образовательное IT-сообщество Skill Branch
 */