package ru.skillbranch.devintensive.models

import java.util.*

abstract class BaseMessage (
    val id: String,
    val from: User?,
    val chat: Chat,
    val isIncoming: Boolean = false,
    val date: Date = Date()
) {
    abstract fun formatMessage(): String?

    companion object Factor{
        var last_id = -1
        fun makeMassage(from: User, chat: Chat, date: Date, payload: BaseMessage, type: String, isIncoming: Boolean = false): BaseMessage {
            return when (type){
                "image" -> ImageMessage(last_id.toString(), from, chat, isIncoming, date, "https:\\anyurl.com")
                else  -> TextMessage(last_id.toString(), from, chat, isIncoming, date, "any text")
            }
        }
    }
}
