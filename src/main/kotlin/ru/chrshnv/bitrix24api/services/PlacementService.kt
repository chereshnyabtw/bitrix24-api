package ru.chrshnv.bitrix24api.services

import org.springframework.http.ResponseEntity
import ru.chrshnv.bitrix24api.config.RestTemplateConfig
import ru.chrshnv.bitrix24api.config.Settings
import ru.chrshnv.bitrix24api.models.PlacementBind

class PlacementService {
	fun bind(binding: PlacementBind): ResponseEntity<String> {
		val restTemplate = RestTemplateConfig.getRestTemplate()

		return restTemplate
			.getForEntity("${Settings.getInstance().url}placement.bind/?placement=${binding.placement}&handler=${binding.handler}&tittle=${binding.tittle}&", String::class.java)
	}
}
