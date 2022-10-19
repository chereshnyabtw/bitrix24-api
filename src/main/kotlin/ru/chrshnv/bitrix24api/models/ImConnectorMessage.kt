package ru.chrshnv.bitrix24api.models

data class ImConnectorMessage(val user: ImConnectorUser = ImConnectorUser(), val message: ImConnectorMessageText = ImConnectorMessageText(), val chat: ImConnectorChat = ImConnectorChat()) {
	data class ImConnectorChat(val id: String = "", val name: String = "", val url: String = "")

	data class ImConnectorMessageText(val text: String = "", val date: Long = 0)

	data class ImConnectorUser(val id: String = "", val name: String = "")
}
