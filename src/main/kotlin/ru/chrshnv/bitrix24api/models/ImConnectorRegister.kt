package ru.chrshnv.bitrix24api.models

import com.fasterxml.jackson.annotation.JsonProperty

data class ImConnectorRegister (
	val id: String = "",
	val name: String = "",

	@get:JsonProperty("placement_handler")
	val placementHandler: String = "",
	val icon: BitrixIcon = BitrixIcon()
) {
	data class BitrixIcon(
		@get:JsonProperty("data_image")
		val dataImage: String = "",
		val color: String = "",
		val position: String = ""
	)
}
