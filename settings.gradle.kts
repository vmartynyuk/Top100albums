pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Top100Albums"
include(":app")
include(":core:ui")
include(":core:navigation")
include(":data:network")
include(":data:database")
include(":feature:albums")
include(":feature:details")
