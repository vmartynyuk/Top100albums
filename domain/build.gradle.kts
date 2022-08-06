plugins {
    id("top100albums.android.library")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

dependencies {

    implementation(project(":data:network"))
    implementation(project(":data:database"))
    implementation(project(":core:model"))

    implementation(Libs.hilt_android)
    kapt(Libs.hilt_compiler)

    implementation(Libs.androidx_startup)
}