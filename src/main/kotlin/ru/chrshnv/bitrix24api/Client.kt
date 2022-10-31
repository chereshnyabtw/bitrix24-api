package ru.chrshnv.bitrix24api

import ru.chrshnv.bitrix24api.config.Settings
import ru.chrshnv.bitrix24api.services.*
import ru.chrshnv.bitrix24api.utils.UrlDecoder

class Client(
	private val clientId: String,
	private val clientSecret: String,
	private val placementService: PlacementService = PlacementService(),
	private val connectorService: ImConnectorService = ImConnectorService(),
	private val eventService: EventService = EventService(),
	private val userService: UserService = UserService(),
	private val userFieldService: UserFieldService
)
{
	fun getPlacementService() = placementService

	fun getConnectorService() = connectorService

	fun getEventService() = eventService

	fun getUserService() = userService

	fun getUserFieldService() = userFieldService

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
