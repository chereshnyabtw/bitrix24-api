package ru.chrshnv.bitrix24api.models

import com.fasterxml.jackson.annotation.JsonProperty

data class ActivationHandler(
	@get:JsonProperty("CONNECTOR") val connector: String = "",
	@get:JsonProperty("LINE") val line: String = "",
	@get:JsonProperty("ACTIVE_STATUS") val active: Boolean = false,
	@get:JsonProperty("STATUS") val status: Boolean = false,
	@get:JsonProperty("CONNECTION_STATUS") val connectionStatus: Boolean = false,
	@get:JsonProperty("REGISTER_STATUS") val registerStatus: Boolean = false,
	@get:JsonProperty("ERROR_STATUS") val errorStatus: Boolean = false
)
