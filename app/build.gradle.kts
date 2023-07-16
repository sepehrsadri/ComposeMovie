plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.kotlinParcelize)
    id(Plugins.hilt)
    id(Plugins.composeCompilerHtmlReport) version Versions.composeCompilerHtmlReport
}

android {
    namespace = "com.sadri.composemovie"
    compileSdk = Android.compileSdkVersion

    defaultConfig {
        applicationId = Android.applicationId
        minSdk = Android.minSdkVersion
        targetSdk = Android.targetSdkVersion
        versionCode = Android.versionCode
        versionName = Android.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName(Android.debug) {
            isShrinkResources = false
            isMinifyEnabled = false
            isCrunchPngs = false
            isDebuggable = true
            enableUnitTestCoverage = true
            applicationIdSuffix = ".dev"
            versionNameSuffix = "-dev"
            signingConfig = signingConfigs.getByName(Android.debug)
            addManifestPlaceholders(mapOf("metrixDisabled" to true))
        }
        getByName(Android.release) {
            isShrinkResources = true
            isMinifyEnabled = true
            isCrunchPngs = true
            isDebuggable = false
            enableUnitTestCoverage = false
            addManifestPlaceholders(mapOf("metrixDisabled" to false))
            proguardFiles(
                "proguard-rules.pro", getDefaultProguardFile("proguard-android.txt")
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.kotlinCompilerExtensionVersion
    }
}

dependencies {
    implementation(project(":library:designsystem"))
    implementation(project(":library:core"))

    implementation(Libs.Common.kotlinLib)
    implementation(Libs.Common.coroutines)
    implementation(Libs.Common.coroutinesAndroid)

    implementation(Libs.Common.coreKtx)
    implementation(Libs.Common.viewModelKtx)
    implementation(Libs.Common.liveDataKtx)
    implementation(Libs.Common.composeActivity)
    implementation(Libs.Common.composeUi)
    implementation(Libs.Common.composeRunTime)
    implementation(Libs.Common.composeUiToolingPreview)
    implementation(Libs.Common.worker)
    debugImplementation(Libs.Common.composeUiTooling)

    implementation(Libs.Common.performance)
    implementation(Libs.Common.tracing)

    implementation(Libs.Common.material)
    implementation(Libs.Common.composeMaterial3)
    implementation(Libs.Common.composeMaterial)
    implementation(Libs.Common.material3WindowSize)

    implementation(Libs.Common.navigation)
    implementation(Libs.Common.navigationKtx)

    implementation(Libs.Common.hilt)
    kapt(Libs.Common.hiltCompiler)
    implementation(Libs.Common.androidxHiltWork)

    testImplementation(Libs.Testing.junit)
    testImplementation(Libs.Testing.coroutinesTest)
    testImplementation(Libs.Testing.mockitoKotlin)
    testImplementation(Libs.Testing.testRunner)
    testImplementation(Libs.Testing.coreTesting)
    androidTestImplementation(Libs.Testing.testExtJunit)
}