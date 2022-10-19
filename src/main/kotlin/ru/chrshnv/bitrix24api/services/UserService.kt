package ru.chrshnv.bitrix24api.services

import org.springframework.http.ResponseEntity
import ru.chrshnv.bitrix24api.config.RestTemplateConfig
import ru.chrshnv.bitrix24api.config.Settings
import ru.chrshnv.bitrix24api.models.CurrentUser
import ru.chrshnv.bitrix24api.models.UserAdmin

class UserService {
	fun current(accessToken: String): ResponseEntity<CurrentUser> {
		val restTemplate = RestTemplateConfig.getRestTemplate()

		return restTemplate
			.getForEntity("${Settings.getInstance().url}user.current.json/?auth=$accessToken", CurrentUser::class.java)
	}

	fun admin(accessToken: String): ResponseEntity<UserAdmin> {
		val restTemplate = RestTemplateConfig.getRestTemplate()

		return restTemplate
			.getForEntity(
				"${Settings.getInstance().url}user.admin/?auth=$accessToken",
				UserAdmin::class.java
			)
	}
}
