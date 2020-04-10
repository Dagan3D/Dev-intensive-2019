package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR
const val YEAR = 365 * DAY

fun Date.format (pattern: String = "HH:mm:ss dd.MM.yy " ): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND):Date{
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date: Date = Date()): String{
    var difference = date.time - this.time
    if (difference > 0){
        return when (difference) {
            in 0..SECOND -> "Только что"
            in SECOND..MINUTE -> "${TimeUnits.SECOND.plural(difference / SECOND)} назад"
            in MINUTE..HOUR -> "${TimeUnits.MINUTE.plural(difference / MINUTE)} назад"
            in HOUR..DAY -> "${TimeUnits.HOUR.plural(difference / HOUR)} назад"
            in DAY..YEAR -> "${TimeUnits.DAY.plural(difference / DAY)} назад"
            else -> "более года назад"
        }
    } else {
        difference = -difference
        return when (difference){
            in 0..SECOND        -> "Только что"
            in SECOND..MINUTE   -> "через ${TimeUnits.SECOND.plural(difference / SECOND)}"
            in MINUTE..HOUR     -> "через ${TimeUnits.MINUTE.plural(difference/ MINUTE)}"
            in HOUR..DAY        -> "через ${TimeUnits.HOUR.plural(difference/ HOUR)}"
            in DAY..YEAR        -> "через ${TimeUnits.DAY.plural(difference/ DAY)}"
            else                -> "более чем через год"
            }
        }
}

interface Number{
    fun plural(i: Long):String?
}

enum class TimeUnits: Number{
    SECOND {
        private val i1 = 0

        @Override
        override fun plural(i: Long): String? {

            return if (i <= 20) {
                when (i) {
                    0L -> "только что"
                    1L -> "1 секунду"
                    in 2..4 -> "$i секунды"
                    in 5..20 -> "$i секунд"
                    else -> "Ошибка"
                }

            } else {
                when (i % 10) {
                    0L -> "$i секунд"
                    1L -> "$i секунду"
                    in 2..4 -> "$i секунды"
                    in 5..9 -> "$i секунд"
                    else -> "Ошибка"
                }
            }
        }
    },
    MINUTE{
        @Override
        override fun plural(i: Long): String? {

            return if (i <= 20) {
                when (i) {
                    0L -> "только что"
                    1L -> "1 минуту"
                    in 2..4 -> "$i минуты"
                    in 5..20 -> "$i минут"
                    else -> "Ошибка" }

            } else {
                when (i % 10) {
                    0L -> "$i минут"
                    1L -> "$i минуту"
                    in 2..4 -> "$i минуты"
                    in 5..9 -> "$i минут"
                    else -> "Ошибка"
                }
            }
        }
    },
    HOUR{
        override fun plural(i: Long): String? {

        return if (i <= 20) {
            when (i) {
                0L -> "только что"
                1L -> "1 час"
                in 2..4 -> "$i часа"
                in 5..20 -> "$i часов"
                else -> "Ошибка" }

        } else {
            when (i % 10) {
                0L -> "$i часов"
                1L -> "$i час"
                in 2..4 -> "$i часа"
                in 5..9 -> "$i часов"
                else -> "Ошибка"
            }
        }
    }
    },
    DAY{
        override fun plural(i: Long): String? {

            return if (i <= 20) {
                when (i) {
                    0L -> "только что"
                    1L -> "1 день"
                    in 2..4 -> "$i дня"
                    in 5..20 -> "$i деней"
                    else -> "Ошибка" }

                } else {
                    when (i % 10) {
                        0L -> "$i дней"
                        1L -> "$i день"
                        in 2..4 -> "$i дня"
                        in 5..9 -> "$i дней"
                        else -> "Ошибка"
                    }
                }
            }
        }
    }

/*
    Реализуй extension Date.format(pattern) возвращающий отформатированную дату по паттерну передаваемому в качестве аргумента (значение по умолчанию "HH:mm:ss dd.MM.yy" локаль "ru")
    Пример:
    Date().format() //14:00:00 27.06.19
    Date().format("HH:mm") //14:00
 */
/*
    Реализуй extension Date.add(value, TimeUnits) добавляющий или вычитающий значение переданное первым аргументом в единицах измерения второго аргумента (enum TimeUnits [SECOND, MINUTE, HOUR, DAY]) и возвращающий модифицированный экземпляр Date
    Пример:
    Date().add(2, TimeUnits.SECOND) //Thu Jun 27 14:00:02 GST 2019
    Date().add(-4, TimeUnits.DAY) //Thu Jun 23 14:00:00 GST 2019
 */
/*
    Реализуй extension Date.humanizeDiff(date) (значение по умолчанию текущий момент времени)
    для форматирования вывода разницы между датами в человекообразном формате, с учетом склонения числительных.
    Временные интервалы преобразований к человекообразному формату доступны в ресурсах к заданию
    Пример:
    Date().add(-2, TimeUnits.HOUR).humanizeDiff() //2 часа назад
    Date().add(-5, TimeUnits.DAY).humanizeDiff() //5 дней назад
    Date().add(2, TimeUnits.MINUTE).humanizeDiff() //через 2 минуты
    Date().add(7, TimeUnits.DAY).humanizeDiff() //через 7 дней
    Date().add(-400, TimeUnits.DAY).humanizeDiff() //более года назад
    Date().add(400, TimeUnits.DAY).humanizeDiff() //более чем через год
 */
/*
   Реализуй метод plural для всех перечислений TimeUnits следующего вида TimeUnits.SECOND.plural(value:Int) возвращающую значение в виде строки с праильно склоненной единицой измерения
    Пример:
    TimeUnits.SECOND.plural(1) //1 секунду
    TimeUnits.MINUTE.plural(4) //4 минуты
    TimeUnits.HOUR.plural(19) //19 часов
    TimeUnits.DAY.plural(222) //222 дня
 */
