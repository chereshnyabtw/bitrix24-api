package ru.chrshnv.bitrix24api.services

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.HttpStatusCodeException
import org.springframework.web.client.postForEntity
import ru.chrshnv.bitrix24api.config.RestTemplateConfig
import ru.chrshnv.bitrix24api.config.Settings
import ru.chrshnv.bitrix24api.models.UserFieldAdd

class UserFieldService {
	fun addType(add: UserFieldAdd): ResponseEntity<String>? {
		val restTemplate = RestTemplateConfig.getRestTemplate()

		for (i in 1..3) {
			try {
				return restTemplate
					.postForEntity("${Settings.getInstance().url}userfieldtype.add/?USER_TYPE_ID=${add.userTypeId}&HANDLER=${add.handler}&TITTLE=${add.tittle}",
						String::class.java)
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
