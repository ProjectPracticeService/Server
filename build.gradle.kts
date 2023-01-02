import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion = "1.8.0"
val springBootVersion = "3.0.1"
val jacksonVersion = "2.14.0"
val mySQLVersion = "8.0.31"
val jwtVersion = "0.11.5"

plugins {
	id("org.springframework.boot") version "3.0.1"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.8.0"
	kotlin("plugin.spring") version "1.8.0"
	kotlin("plugin.jpa") version "1.8.0"
}

group = "ru.mephi"
version = "0.0.1"
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
	implementation("org.springframework.boot:spring-boot-starter-validation:$springBootVersion")
	implementation("org.springframework.boot:spring-boot-starter-security:$springBootVersion")
	developmentOnly("org.springframework.boot:spring-boot-devtools:$springBootVersion")
	testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootVersion")

	// Jackson
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")

	// MySQL
	implementation("com.mysql:mysql-connector-j:$mySQLVersion")

	// JWT
	api("io.jsonwebtoken:jjwt-api:$jwtVersion")
	runtimeOnly("io.jsonwebtoken:jjwt-impl:$jwtVersion")
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:$jwtVersion")

	//DTO
	implementation("org.modelmapper:modelmapper:3.1.0")
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
