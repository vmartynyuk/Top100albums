plugins {
    id("top100albums.android.library")
    id("dagger.hilt.android.plugin")
    id("kotlinx-serialization")
    kotlin("kapt")
}

dependencies {
    implementation(Libs.kotlinx_serialization_json)

    implementation(Libs.retrofit_core)
    implementation(Libs.okhttp)
    implementation(Libs.retrofit_kotlin_serialization)

    implementation(Libs.hilt_android)
    kapt(Libs.hilt_compiler)
}