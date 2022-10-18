package ru.chrshnv.bitrix24api.models

import com.fasterxml.jackson.annotation.JsonProperty

data class AccessToken(
	@get:JsonProperty("access_token")
	val accessToken: String = "",

	@get:JsonProperty("refresh_token")
	val refreshToken: String = ""
)
