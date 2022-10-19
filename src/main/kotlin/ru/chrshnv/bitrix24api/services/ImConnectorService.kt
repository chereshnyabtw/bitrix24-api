package ru.chrshnv.bitrix24api.services

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.HttpStatusCodeException
import ru.chrshnv.bitrix24api.config.RestTemplateConfig
import ru.chrshnv.bitrix24api.config.Settings
import ru.chrshnv.bitrix24api.models.ActivationHandler
import ru.chrshnv.bitrix24api.models.ImConnectorRegister

class ImConnectorService {
	fun register(registration: ImConnectorRegister): ResponseEntity<String>? {
		val restTemplate = RestTemplateConfig.getRestTemplate()
		val json = jacksonObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(registration)
		val entity = HttpEntity(json)

		for (i in 1..3) {
			try {
				return restTemplate
					.postForEntity(
						"${Settings.getInstance().url}imconnector.register/?auth=${Settings.getInstance().accessToken}",
						entity,
						String::class.java
					)
			} catch (e: HttpStatusCodeException) {
				if(i < 3 && e.statusCode == HttpStatus.UNAUTHORIZED)
					continue
				else
					throw e
			}
		}

		return null
	}

	fun activate(activation: ActivationHandler): ResponseEntity<String>? {
		val restTemplate = RestTemplateConfig.getRestTemplate()

		Settings.getInstance().connector = activation.connector
		Settings.getInstance().lineId = activation.line

		for (i in 1..3) {
			try {
				return restTemplate
					.getForEntity(
						"${Settings.getInstance().url}imconnector.activate/?Connector=${activation.connector}&Line=${activation.line}&Active=${activation.active.toInt()}&auth=${Settings.getInstance().accessToken}",
						String::class.java
					)
			} catch (e: HttpStatusCodeException) {
				if(i < 3 && e.statusCode == HttpStatus.UNAUTHORIZED)
					continue
				else
					throw e
			}
		}

		return null
	}

	private fun Boolean.toInt() = if (this) 1 else 0
}
