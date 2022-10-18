package ru.chrshnv.bitrix24api

class Client(val clientId: String, val clientSecret: String) {
	fun setup(body: String) {
		println(body)
	}
}
