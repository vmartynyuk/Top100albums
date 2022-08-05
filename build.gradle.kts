buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Libs.android_gradlePlugin)
        classpath(Libs.kotlin_gradlePlugin)
        classpath(Libs.hilt_gradlePlugin)
        classpath("com.android.tools.build:gradle:7.2.1")
    }
}