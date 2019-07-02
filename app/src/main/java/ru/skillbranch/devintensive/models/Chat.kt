package ru.skillbranch.devintensive.models

/**
 * Сущность "Чат", содержащая относящиеся к ней сообщения и пользователей-участников
 * @author apolyakov
 * @since 01.07.2019
 */
class Chat(
    val id: String,
    members: MutableList<User> = mutableListOf(),
    messages: MutableList<BaseMessage> = mutableListOf()
) {

}