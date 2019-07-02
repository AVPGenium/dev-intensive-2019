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
}