plugins {
    id("java")
    kotlin("jvm")
}

group = "com.eltex"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    "testImplementation"(platform("org.junit:junit-bom:5.10.0"))
    "testImplementation"("org.junit.jupiter:junit-jupiter")
    compileOnly("org.jetbrains:annotations:24.1.0")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(23)
}

sourceSets {
    main {
        java.srcDirs("src/main/java", "src/main/kotlin")
    }
}