plugins {
    kotlin("jvm") version "2.1.0"
    // Plugin de Dokka
    id("org.jetbrains.dokka") version "1.9.20"
    application
    // Plugin para serializar
    kotlin("plugin.serialization") version "2.1.0"
}

group = "prog.trbe2"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
    // Dependencias de Dokka
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:1.9.20")
    // Dependencias de Logger
    implementation("org.lighthousegames:logging:1.5.0")
    implementation("ch.qos.logback:logback-classic:1.5.12")
    // Dependencias de Serializacion
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.5.1")
    // Dependencias de Json
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
    // Dependencias de XML
        implementation("io.github.pdvrieze.xmlutil:serialization-jvm:0.90.3")
        implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.15.0")

}
tasks.test {
    useJUnitPlatform()
}
tasks.jar {
    manifest {
        attributes["Main-Class"] = "prog.trbe2.MainKt"
    }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
kotlin {
    jvmToolchain(17)
}