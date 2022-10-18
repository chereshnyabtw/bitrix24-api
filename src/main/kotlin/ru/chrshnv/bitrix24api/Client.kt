package ru.chrshnv.bitrix24api

import ru.chrshnv.bitrix24api.config.Settings
import ru.chrshnv.bitrix24api.services.PlacementService
import ru.chrshnv.bitrix24api.utils.UrlDecoder

class Client(private val clientId: String, private val clientSecret: String, private val placementService: PlacementService = PlacementService()) {
	fun getPlacementService(): PlacementService {
		return placementService
	}

	fun setup(body: String) {
		Settings.getInstance().clientId = clientId
		Settings.getInstance().clientSecret = clientSecret

		val params = UrlDecoder.parseFromString(body)
		Settings.getInstance().accessToken = params["auth[access_token]"]
		Settings.getInstance().refreshToken = params["auth[refresh_token]"]
		Settings.getInstance().url = params["auth[client_endpoint]"]
		Settings.getInstance().applicationToken = params["auth[application_token]"]
	}
}
