package ru.chrshnv.bitrix24api.services

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.HttpStatusCodeException
import ru.chrshnv.bitrix24api.config.RestTemplateConfig
import ru.chrshnv.bitrix24api.config.Settings
import ru.chrshnv.bitrix24api.models.PlacementBind

class PlacementService {
	fun bind(binding: PlacementBind): ResponseEntity<String>? {
		val restTemplate = RestTemplateConfig.getRestTemplate()

		for (i in 1..3) {
			try {
				return restTemplate
					.getForEntity(
						"${Settings.getInstance().url}placement.bind/?placement=${binding.placement}&handler=${binding.handler}&tittle=${binding.tittle}&auth=${Settings.getInstance().accessToken}",
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
}
