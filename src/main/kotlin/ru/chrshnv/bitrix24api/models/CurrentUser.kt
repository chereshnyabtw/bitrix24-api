package ru.chrshnv.bitrix24api.models

import com.fasterxml.jackson.annotation.JsonProperty

data class CurrentUser(
	val result: User = User()
) {
	data class User(
		@get:JsonProperty("ID") val id: Long = 0,
		@get:JsonProperty("ACTIVE") val active: Boolean = false,
		@get:JsonProperty("NAME") val name: String = "",
		@get:JsonProperty("LAST_NAME") val lastName: String = "",
		@get:JsonProperty("EMAIL") val email: String = ""
	)
}
