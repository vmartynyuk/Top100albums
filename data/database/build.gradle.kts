plugins {
    id("top100albums.android.library")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
    id("io.realm.kotlin")
}

dependencies {
    implementation(project(":core:model"))

    implementation(Libs.realm_kotlin_base)

    implementation(Libs.hilt_android)
    kapt(Libs.hilt_compiler)

    implementation(Libs.androidx_startup)
}