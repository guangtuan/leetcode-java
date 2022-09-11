package tech.igrant.support

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.net.URL

class KtJSON {

    companion object {
        private val mapper = ObjectMapper().also { it.registerKotlinModule() }

        fun <T> read(f: URL, c: Class<T>): T = mapper.readValue(f, c)
    }

}