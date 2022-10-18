package ru.chrshnv.bitrix24api.utils

import java.net.URLDecoder
import java.nio.charset.StandardCharsets

class UrlDecoder {
	companion object {
		fun parseFromString(body: String): MutableMap<String, String> {
			val decoded = URLDecoder.decode(body, StandardCharsets.UTF_8)
			val things = decoded.split("&".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
			val params: MutableMap<String, String> = HashMap()
			things.forEach { param ->
				val paramSplit = param.split("=".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
				params[paramSplit[0]] = paramSplit[1]
			}

			return params
		}
	}
}
