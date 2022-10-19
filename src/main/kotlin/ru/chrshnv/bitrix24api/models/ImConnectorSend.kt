package ru.chrshnv.bitrix24api.models

data class ImConnectorSend (val connector: String = "", val line: Int = 0) {
	var messages: ArrayList<ImConnectorMessage> = arrayListOf()
}

