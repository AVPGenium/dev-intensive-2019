package ru.skillbranch.devintensive.utils

/**
 * Утилитные методы для работы преобразований, связанных с сущностью Пользователь
 * @author apolyakov
 * @since 01.07.2019
 */
object Utils {
    /**
     * Получить пару <Имя, Фамилия> из полного имени (Имя Фамилия)
     * @param fullName полное имя
     * @return пара <Имя, Фамилия>
     */
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        //Удаляем пробелы в начале и в конце
        var newName = fullName?.trimStart()?.trimEnd()
        //Заменяем мульти пробелы одним пробелом
        newName = newName?.replace(Regex("\\s{2,}")," ")

        val parts: List<String>? = newName?.split(" ")
        var firstName = parts?.getOrNull(0)
        if (firstName.isNullOrEmpty())
        {
            firstName = null
        }
        var lastName = parts?.getOrNull(1)
        if (lastName.isNullOrEmpty())
        {
            lastName = null
        }
        return firstName to lastName
    }

    /**
     * Преобразует полные Имя-Фамилия в инициалы
     * @param firstName имя
     * @param lastName фамилия
     * @return инициалы
     */
    fun toInitials(firstName: String?, lastName: String?): String? {
        return when {
            firstName.isNullOrBlank() && lastName.isNullOrBlank() -> null
            firstName.isNullOrBlank() -> "${lastName?.get(0)}".toUpperCase()
            lastName.isNullOrBlank() -> "${firstName[0]}".toUpperCase()
            else -> "${firstName[0]}${lastName[0]}".toUpperCase()
        }
    }

    /**
     * Преобразование строки из русских букв в строку с английскими буквами
     * @param payload исходная строка для преобразования
     * @param divider разделитель (по умолчанию пробел)
     * @return строка из английских символов
     */
    fun transliteration(payload: String, divider: String = " ") = payload.map {
        val isUpper = it.isUpperCase()
        val transLetter = when (it.toLowerCase()) {
            'а' -> "a"
            'б' -> "b"
            'в' -> "v"
            'г' -> "g"
            'д' -> "d"
            'е', 'ё', 'э' -> "e"
            'ж' -> "zh"
            'з' -> "z"
            'и', 'й', 'ы' -> "i"
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
            'щ' -> "shch"
            'ъ', 'ь' -> ""
            'ю' -> "yu"
            'я' -> "ya"
            ' ' -> divider
            else -> "$it"
        }
        if (isUpper) transLetter.capitalize() else transLetter
    }.joinToString("")
}