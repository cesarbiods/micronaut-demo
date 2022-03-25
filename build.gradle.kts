plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.10"
    id("org.jetbrains.kotlin.kapt") version "1.6.10"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.10"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.6.10"
    id("com.github.johnrengelman.shadow") version "7.1.1"
    id("io.micronaut.application") version "3.2.2"
    id("org.hibernate.orm") version "5.6.5.Final"
}

version = "0.1"
group = "com.cesarbiods"

val kotlinVersion=project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
}

dependencies {
    kapt("io.micronaut:micronaut-http-validation")
    kapt("io.micronaut.data:micronaut-data-processor")
    kapt("io.micronaut.openapi:micronaut-openapi")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut.data:micronaut-data-hibernate-jpa")
    implementation("io.micronaut.elasticsearch:micronaut-elasticsearch")
    implementation("io.micronaut.kafka:micronaut-kafka")
    implementation("io.micronaut.kotlin:micronaut-kotlin-extension-functions")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    implementation("jakarta.annotation:jakarta.annotation-api")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    implementation("org.slf4j:slf4j-api:1.7.36")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("com.h2database:h2")
    compileOnly("org.graalvm.nativeimage:svm")

    implementation("io.micronaut:micronaut-validation")

    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")

}

configurations.all {
    exclude("org.apache.logging.log4j", "log4j-api")
    exclude("org.apache.logging.log4j", "log4j-core")
}

application {
    mainClass.set("com.cesarbiods.ApplicationKt")
}
java {
    sourceCompatibility = JavaVersion.toVersion("17")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
    withType<org.hibernate.orm.tooling.gradle.EnhanceTask>().configureEach {
        options.enableLazyInitialization = true
        options.enableDirtyTracking = true
        options.enableAssociationManagement = true
        options.enableExtendedEnhancement = false
    }
}
graalvmNative.toolchainDetection.set(false)
graalvmNative {
    binaries {
        named("main") {
            buildArgs.add("--allow-incomplete-classpath")
//            buildArgs.add("-H:ReflectionConfigurationFiles=resources/reflect-config.json")
//            buildArgs.add("--initialize-at-build-time=org.slf4j.simple.SimpleLogger,org.slf4j.LoggerFactory,org.apache.logging.slf4j.SLF4JLogger,org.apache.logging.slf4j.SLF4JLoggerContext,org.apache.logging.log4j.LogManager,org.jboss.logging.Log4j2Logger,org.jboss.logging.Log4j2LoggerProvider,org.jboss.logging.Logger,org.hibernate.secure.internal.StandardJaccServiceImpl,org.postgresql.sspi.SSPIClient,org.hibernate.dialect.OracleTypesHelper")
//            buildArgs.add("--trace-class-initialization=org.apache.logging.log4j.util.PropertySource\$Util")
//            buildArgs.add("--initialize-at-run-time=org.slf4j.impl.StaticLoggerBinder,org.slf4j.LoggerFactory,ch.qos.logback.classic.Logger,ch.qos.logback.core.spi.AppenderAttachableImpl,ch.qos.logback.core.status.StatusBase,ch.qos.logback.classic.Level,ch.qos.logback.core.status.InfoStatus,ch.qos.logback.classic.PatternLayout,ch.qos.logback.core.CoreConstants")
        }
    }
}
micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.cesarbiods.*")
    }
}


