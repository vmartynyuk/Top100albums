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
                add("implementation", project(":core:model"))
                add("implementation", project(":core:common"))
                add("implementation", project(":core:ui"))
                add("implementation", project(":core:navigation"))
                add("implementation", project(":domain"))

                add("implementation", Libs.androidx_hilt_navigation_compose)
                add("implementation", Libs.google_accompanist_systemuicontroller)

                add("implementation", Libs.coilKt)
                add("implementation", Libs.coilKt_compose)

                add("implementation", Libs.hilt_android)
                add("kapt", Libs.hilt_compiler)

                add("debugImplementation", Libs.androidx_customview_poolingcontainer)
            }
        }
    }
}