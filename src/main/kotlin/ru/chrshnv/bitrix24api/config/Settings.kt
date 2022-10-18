package ru.chrshnv.bitrix24api.config

class Settings {
	var applicationToken: String? = null
	var url: String? = null
	var accessToken: String? = null
	var refreshToken: String? = null

	var clientId: String = ""
	var clientSecret: String = ""

	companion object {
		private var sInstance: Settings? = null

		fun getInstance(): Settings {
			if(sInstance == null)
				sInstance = Settings()

			return sInstance ?: throw IllegalStateException("")
		}
	}
}
