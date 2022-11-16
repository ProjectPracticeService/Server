import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion = "1.7.20"
val springBootVersion = "2.7.5"
val jacksonVersion = "2.14.0"
val yamlVersion = "1.33"

plugins {
	id("org.springframework.boot") version "2.7.5"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.20"
	kotlin("plugin.spring") version "1.7.20"
//	kotlin("plugin.jpa") version "1.3.61"
	id("org.jetbrains.kotlin.plugin.noarg") version "1.5.31"
//	id("org.jetbrains.kotlin.plugin.jpa") version "1.5.31"
//	id("org.jetbrains.kotlin.plugin.allOpen") version "1.5.31"
	application
}



allOpen{
	annotations(
		"javax.persistence.Entity",
		"javax.persistence.MappedSuperclass",
		"javax.persistence.Embedabble"
	)
}

group = "ru.mephi"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {

	// Kotlin
	implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")

	// Spring Boot
	implementation("org.springframework.boot:spring-boot-starter-web:$springBootVersion")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:$springBootVersion")
	developmentOnly("org.springframework.boot:spring-boot-devtools:$springBootVersion")
	testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootVersion")
//	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
	implementation("javax.xml.bind:jaxb-api")


	implementation("mysql:mysql-connector-java:8.0.17")

	// Jackson
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")

	// YAML
	implementation("org.yaml:snakeyaml:$yamlVersion")

	//postgresql
	implementation ("org.postgresql:postgresql")

//	implementation("mysql:mysql-connector-java:8.0.25")
//	implementation("org.hibernate:hibernate-core:5.5.8.Final")

//	implementation("org.springframework.boot:spring-boot-starter-jdbc")
//	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
