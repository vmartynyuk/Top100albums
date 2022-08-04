buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Libs.android_gradlePlugin)
        classpath(Libs.kotlin_gradlePlugin)
        classpath(Libs.hilt_gradlePlugin)
    }
}