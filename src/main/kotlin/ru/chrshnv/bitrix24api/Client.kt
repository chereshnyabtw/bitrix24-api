package ru.chrshnv.bitrix24api

import ru.chrshnv.bitrix24api.config.Settings
import ru.chrshnv.bitrix24api.services.*
import ru.chrshnv.bitrix24api.utils.UrlDecoder

class Client(private val clientId: String, private val clientSecret: String, private val placementService: PlacementService = PlacementService(), private val connectorService: ImConnectorService = ImConnectorService(), private val eventService: EventService = EventService(), private val userService: UserService = UserService(), private val userFieldService: UserFieldService) {
	fun getPlacementService(): PlacementService {
		return placementService
	}

	fun getConnectorService(): ImConnectorService {
		return connectorService
	}

	fun getEventService(): EventService {
		return eventService
	}

	fun getUserService(): UserService {
		return userService
	}

	fun getUserFieldService(): UserFieldService {
		return userFieldService
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
