plugins {
    id("top100albums.android.application")
    id("top100albums.android.application.compose")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    defaultConfig {
        applicationId = "ua.vmartyniuk.top100albums"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:ui"))
    implementation(project(":core:navigation"))
    implementation(project(":feature:albums"))
    implementation(project(":feature:details"))

    implementation(Libs.androidx_activity_compose)
    implementation(Libs.androidx_appcompat)
    implementation(Libs.androidx_coreKtx)
    implementation(Libs.material)

    implementation(Libs.hilt_android)
    kapt(Libs.hilt_compiler)
}