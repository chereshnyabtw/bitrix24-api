package ru.chrshnv.bitrix24api.services

import org.springframework.http.ResponseEntity
import org.springframework.web.client.postForEntity
import ru.chrshnv.bitrix24api.config.RestTemplateConfig
import ru.chrshnv.bitrix24api.config.Settings
import ru.chrshnv.bitrix24api.models.UserFieldAdd

class UserFieldService {
	fun addType(add: UserFieldAdd): ResponseEntity<String> {
		val restTemplate = RestTemplateConfig.getRestTemplate()

		return restTemplate
				.postForEntity("${Settings.getInstance().url}userfieldtype.add/?USER_TYPE_ID=${add.userTypeId}&HANDLER=${add.handler}&TITTLE=${add.tittle}",
				String::class.java)
	}
}
