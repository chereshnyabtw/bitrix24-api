package ru.chrshnv.bitrix24api.services

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.HttpStatusCodeException
import ru.chrshnv.bitrix24api.config.RestTemplateConfig
import ru.chrshnv.bitrix24api.config.Settings
import ru.chrshnv.bitrix24api.models.PlacementBind
import java.util.logging.Logger

class PlacementService {
	private val logger: Logger = Logger.getLogger(this.javaClass.name)

	fun bind(binding: PlacementBind): ResponseEntity<String>? {
		val restTemplate = RestTemplateConfig.getRestTemplate()

		var response: ResponseEntity<String>? = null

		try {
			response = restTemplate
				.getForEntity("${Settings.getInstance().url}placement.bind/?placement=${binding.placement}&handler=${binding.handler}&tittle=${binding.tittle}&auth=${Settings.getInstance().accessToken}", String::class.java)
		} catch (e: HttpStatusCodeException) {
			logger.info(e.statusCode.name)
			logger.info(e.responseBodyAsString)

			if(e.statusCode == HttpStatus.UNAUTHORIZED)
				response = bind(binding)
		}

		return response
	}
}
