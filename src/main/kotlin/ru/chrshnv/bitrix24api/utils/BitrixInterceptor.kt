package ru.chrshnv.bitrix24api.utils

import org.springframework.http.HttpRequest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.ClientHttpResponse
import org.springframework.web.client.RestTemplate
import ru.chrshnv.bitrix24api.config.Settings
import ru.chrshnv.bitrix24api.models.AccessToken

class BitrixInterceptor: ClientHttpRequestInterceptor {
	override fun intercept(
		request: HttpRequest,
		body: ByteArray,
		execution: ClientHttpRequestExecution
	): ClientHttpResponse {
		request.headers.contentType = MediaType.APPLICATION_JSON

		val response = execution.execute(request, body)
		if(response.statusCode != HttpStatus.UNAUTHORIZED)
			return response

		val restTemplate = RestTemplate()
		val refreshResponse = restTemplate
			.getForEntity(
				"${Settings.getInstance().url?.replace("/rest/", "/oauth/")}token/?grant_type=refresh_token&client_id=${Settings.getInstance().clientId}&client_secret=${Settings.getInstance().clientSecret}&refresh_token=${Settings.getInstance().refreshToken}",
				AccessToken::class.java
			)

		if(refreshResponse.statusCode != HttpStatus.UNAUTHORIZED) {
			Settings.getInstance().accessToken = refreshResponse.body?.accessToken
			Settings.getInstance().refreshToken = refreshResponse.body?.refreshToken
		}
		return response
	}
}
