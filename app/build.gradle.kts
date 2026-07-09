plugins {

    id("com.android.application")

    id("org.jetbrains.kotlin.android")

    //id("com.chaquo.python")

    id("org.jetbrains.kotlin.plugin.compose")

}

android {

    namespace = "com.drone.activation"

    compileSdk = 35

    defaultConfig {

        applicationId = "com.drone.activation"

        minSdk = 29

        targetSdk = 35

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

    compileOptions {

        sourceCompatibility = JavaVersion.VERSION_17

        targetCompatibility = JavaVersion.VERSION_17

    }

    kotlinOptions {

        jvmTarget = "17"

    }

    buildFeatures {
        compose = true
        // 明确关闭 buildConfig，解决废弃警告
        buildConfig = false
    }

}

dependencies {

    implementation(platform("androidx.compose:compose-bom:2025.01.01"))

    implementation("androidx.core:core-ktx:1.15.0")

    implementation("androidx.activity:activity-compose:1.10.1")

    implementation("androidx.compose.ui:ui")

    implementation("androidx.compose.material3:material3")

    implementation("com.google.android.material:material:1.12.0")

    implementation("androidx.compose.ui:ui-tooling-preview")

    debugImplementation("androidx.compose.ui:ui-tooling")

}