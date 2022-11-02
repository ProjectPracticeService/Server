import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlin_version: String by project
val logback_version: String by project

plugins {
    id("org.springframework.boot") version "2.7.5"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
}


group = "com.example"
version = "0.0.1"


//application{
//    mainClass.set("com.example.ApplicationKt")
//    val isDevelopment: Boolean = project.ext.has("development")
//    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
//}


repositories {
    mavenCentral()


    maven {
        url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
        url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
        url = uri("https://kotlin.bintray.com/kotlinx")
    }

}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.liquibase:liquibase-core")

    runtimeOnly("org.postgresql:postgresql")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
//    testImplementation("org.testcontainers:testcontainers:$testContainersVer")
//    testImplementation("org.testcontainers:postgresql:$testContainersVer")

    testImplementation(kotlin("test-junit"))
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}