package ru.chrshnv.bitrix24api.config

import org.springframework.web.client.RestTemplate
import ru.chrshnv.bitrix24api.utils.BitrixInterceptor

class RestTemplateConfig {
	companion object {
		fun getRestTemplate(): RestTemplate {
			val restTemplate = RestTemplate()
			restTemplate.interceptors.add(BitrixInterceptor())
			return restTemplate
		}
	}
}
