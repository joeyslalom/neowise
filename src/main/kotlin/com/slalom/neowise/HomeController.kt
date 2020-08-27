package com.slalom.neowise

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.info.BuildProperties
import org.springframework.boot.info.GitProperties
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController(private val gitProperties: GitProperties,
                     private val buildProperties: BuildProperties) : InitializingBean {
    private final val log = LoggerFactory.getLogger(HomeController::class.java)

    @Value("\${hostname:no-hostname}")
    private lateinit var hostname: String

    @GetMapping("/")
    fun home(): HomeResponse {
        return HomeResponse("hello", hostname,
                buildProperties.version, gitProperties.shortCommitId)
    }

    override fun afterPropertiesSet() {
        log.info("version=${buildProperties.version}")
        log.info("git commit sha=${gitProperties.shortCommitId}")
    }
}

class HomeResponse(val message: String, val hostname: String,
                   val version: String, val gitsha: String)