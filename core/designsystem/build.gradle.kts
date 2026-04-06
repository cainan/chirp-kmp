plugins {
    alias(libs.plugins.convention.cmp.library)
}

kotlin {

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.stdlib)
                // Add KMP dependencies here

                implementation(projects.core.presentation)

                implementation(libs.coil.compose)
                implementation(libs.coil.network.ktor)

                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        androidMain {
            dependencies {

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

            }
        }
    }

}