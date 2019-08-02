package ru.skillbranch.devintensive.models

import java.util.*

/**
 * Базовая сущность "Сообщение чата", имеет две реализации: текстовое сообщение и сообщение-картинка
 * @author apolyakov
 * @since 01.07.2019
 */
abstract class BaseMessage(
    val id: String,
    val from: User?,
    val chat: Chat,
    val isIncoming: Boolean = false,
    val date: Date = Date()
) {
    /**
     * Получить текстовое представление сообщения
     * @return строка, содержащая информацию о id сообщения, имени получателя/отправителя, виде сообщения ("получил/отправил") и типе сообщения ("сообщение"/"изображение")
     */
    abstract fun formatMessage(): String

    companion object AbstractFactory {
        var lastId: Int = -1

        /**
         * Сформировать сущность сообщения чата из набора данных
         * @return сущность сообщения чата
         */
        fun makeMessage(
            from: User?,
            chat: Chat,
            date: Date = Date(),
            type: String = "text",
            payload: Any?,
            isIncoming: Boolean = false
        ): BaseMessage {
            lastId++
            return when (type) {
                "image" -> ImageMessage("$lastId", from, chat, isIncoming, date, image = payload as String)
                else -> TextMessage("$lastId", from, chat, isIncoming, date, text = payload as String)
            }
        }

    }
}