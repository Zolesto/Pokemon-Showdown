plugins {
    id("com.android.application")
}

// CI passes -PbuildNumber=<run number> so each build installs over the last one.
val buildNumber = (project.findProperty("buildNumber") as String?)?.toIntOrNull() ?: 1

android {
    namespace = "com.zolesto.showdown"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.zolesto.showdown"
        minSdk = 26
        targetSdk = 34
        versionCode = buildNumber
        versionName = "1.0.$buildNumber"
    }

    signingConfigs {
        create("app") {
            // A fixed key kept in the repo, so every CI build has the same
            // signature and updates install without uninstalling first.
            storeFile = file("signing.keystore")
            storePassword = "showdown"
            keyAlias = "showdown"
            keyPassword = "showdown"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("app")
        }
        debug {
            signingConfig = signingConfigs.getByName("app")
        }
    }

    lint {
        checkReleaseBuilds = false
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
