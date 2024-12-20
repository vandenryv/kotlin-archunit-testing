package org.hexavote

import VotePortHashMap
import org.hexavote.domain.VoteService
import org.hexavote.`in`.VoteController
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}

@Component
class VotePortGlue : VotePortHashMap()

@Service
class VoteServiceGlue(glueRepo: VotePortGlue) : VoteService(glueRepo)

@RestController()
@RequestMapping("/api/v1/vote")
class ControllerGlue(service: VoteServiceGlue) : VoteController(service)