package ru.grobikon.micro.grobikonusers

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import kotlin.jvm.JvmStatic
import org.springframework.boot.SpringApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.context.config.annotation.RefreshScope

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = ["ru.grobikon.common", "ru.grobikon.micro.grobikonusers"])
@EnableJpaRepositories(basePackages = ["ru.grobikon.micro.grobikonusers"])
@RefreshScope //динамически читает значения из файла конфигурации
open class GrobikonUsersApplication {

    fun main(args: Array<String>) {
        runApplication<GrobikonUsersApplication>(*args)
    }
}