import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.kapt")
            }

            dependencies {
                add("implementation", project(":core:ui"))
                add("implementation", project(":core:navigation"))

                add("implementation", Libs.androidx_hilt_navigation_compose)

                add("implementation", Libs.hilt_android)
                add("kapt", Libs.hilt_compiler)

                add("debugImplementation", Libs.androidx_customview_poolingcontainer)
            }
        }
    }
}