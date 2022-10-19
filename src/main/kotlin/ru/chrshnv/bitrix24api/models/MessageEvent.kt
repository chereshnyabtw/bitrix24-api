package ru.chrshnv.bitrix24api.models

import ru.chrshnv.bitrix24api.utils.UrlDecoder

class MessageEvent(val applicationToken: String? = "", val event: String? = "", val connector: String? = "", val chatId: String? = "", val text: String? = "") {
	companion object {
		fun create(body: String): MessageEvent {
			val params = UrlDecoder.parseFromString(body)
			return MessageEvent(
				params["auth[application_token]"],
				params["event"],
				params["data[CONNECTOR]"],
				params["data[MESSAGES][0][chat][id]"],
				params["data[MESSAGES][0][message][text]"]
			)
		}
	}
}
