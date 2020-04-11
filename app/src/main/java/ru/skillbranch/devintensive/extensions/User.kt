package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView

fun User.toUserView () : UserView{
    val nickname = ""
    val status = ""
    val initials = if (lastVisit == null) "Ещё ни разу не был" else if (isOnline) "Online" else "Последний раз был ${lastVisit!!.humanizeDiff()}"
    return UserView(
        id,
        fullName = "$firstName $lastName",
        nickname = nickname,
        avatar = avatar,
        status = status,
        initials = initials )
}