plugins {
    alias(libs.plugins.convention.kmp.library)
    alias(libs.plugins.convention.buildkonfig)
}

kotlin {

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.stdlib)

                implementation(projects.core.domain)

                implementation(libs.bundles.ktor.common)

                implementation(libs.touchlab.kermit)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.ktor.client.okhttp)
            }
        }

//        getByName("androidDeviceTest") {
//            dependencies {
//                implementation(libs.androidx.runner)
//                implementation(libs.androidx.test.core)
//                implementation(libs.androidx.junit)
//            }
//        }

        iosMain {
            dependencies {
                implementation(libs.ktor.client.darwin)
            }
        }
    }

}