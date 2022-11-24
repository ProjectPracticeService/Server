import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion = "1.7.20"
val springBootVersion = "2.7.5"
val jacksonVersion = "2.14.0"
val yamlVersion = "1.33"
val mySQLVersion = "8.0.31"
val jaxb by configurations.creating

plugins {
	id("org.springframework.boot") version "2.7.5"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.20"
	kotlin("plugin.spring") version "1.7.20"
	kotlin("plugin.jpa") version "1.7.20"
}

group = "ru.mephi"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

configurations {
	jaxb
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
	implementation("javax.xml.bind:jaxb-api")
//	implementation("com.sun.xml.bind:jaxb-core")
//	implementation("com.sun.xml.bind:jaxb-impl")

	// Jackson
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")

	// YAML
	implementation("org.yaml:snakeyaml:$yamlVersion")

	// MySQL
//	implementation("com.mysql:mysql-connector-j:$mySQLVersion")

	//БД
//	implementation("org.projectlombok:lombok")

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
