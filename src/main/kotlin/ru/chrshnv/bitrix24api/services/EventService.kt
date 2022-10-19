package ru.chrshnv.bitrix24api.services

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.HttpStatusCodeException
import ru.chrshnv.bitrix24api.config.RestTemplateConfig
import ru.chrshnv.bitrix24api.config.Settings
import ru.chrshnv.bitrix24api.models.EventBind

class EventService {
	fun bind(binding: EventBind): ResponseEntity<String>? {
		val restTemplate = RestTemplateConfig.getRestTemplate()

		for (i in 1..3) {
			try {
				return restTemplate
					.getForEntity(
						"${Settings.getInstance().url}event.bind.json?auth=${Settings.getInstance().accessToken}&handler=${binding.handler}&event=${binding.event}",
						String::class.java
					)
			} catch (e: HttpStatusCodeException) {
				if(e.statusCode == HttpStatus.UNAUTHORIZED && i < 3)
					continue
				else
					throw e
			}
		}

		return null
	}
}
