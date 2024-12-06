package org.hexavote

import VoteRepoHashMap
import org.hexavote.api.VoteApi
import org.hexavote.domain.VoteService
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
class VoteRepoGlue : VoteRepoHashMap()

@Service
class VoteServiceGlue(glueRepo: VoteRepoGlue) : VoteService(glueRepo)

@RestController()
@RequestMapping("/api/v1/vote")
class ApiGlue(service: VoteServiceGlue) : VoteApi(service)