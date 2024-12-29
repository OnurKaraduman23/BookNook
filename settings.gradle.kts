pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "BookNook"
include(":app")
include(":core")
include(":features")
include(":features:home")
include(":features:home:data")
include(":features:home:domain")
include(":features:home:presentation")
include(":features:search")
include(":features:search:data")
include(":features:search:domain")
include(":features:search:presentation")
include(":features:favorites")
include(":features:favorites:data")
include(":features:favorites:domain")
include(":features:favorites:presentation")
include(":navigation")
