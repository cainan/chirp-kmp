import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "com.cso.convention.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "com.cso.convention.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
    }

    plugins {
        register("androidComposeApplication") {
            id = "com.cso.convention.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
    }

    plugins {
        register("cmpApplication") {
            id = "com.cso.convention.cmp.application"
            implementationClass = "CmpApplicationConventionPlugin"
        }
    }

    plugins {
        register("kmpLibrary") {
            id = "com.cso.convention.kmp.library"
            implementationClass = "KmpLibraryConventionPlugin"
        }
    }
}