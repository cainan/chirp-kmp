import com.cso.chirp.convention.applyHierarchyTemplate
import com.cso.chirp.convention.configureAndroidTarget
import com.cso.chirp.convention.configureDesktopTarget
import com.cso.chirp.convention.configureIosTargets
import com.cso.chirp.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class CmpApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.cso.convention.android.application.compose")
                apply("org.jetbrains.kotlin.multiplatform")
                apply("org.jetbrains.compose")
                apply("org.jetbrains.kotlin.plugin.compose")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            configureAndroidTarget()
            configureIosTargets()
            configureDesktopTarget()

            extensions.configure<KotlinMultiplatformExtension> {
                applyHierarchyTemplate()
            }

            dependencies {
                "debugImplementation"(libs.findLibrary("androidx-compose-ui-tooling").get())
            }
        }
    }
}