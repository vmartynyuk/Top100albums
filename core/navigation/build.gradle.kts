plugins {
    id("top100albums.android.library")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    api(Libs.androidx_hilt_navigation_compose)
    api(Libs.androidx_navigation_compose)

    implementation(Libs.hilt_android)
    kapt(Libs.hilt_compiler)
}