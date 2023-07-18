plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
}

android {
    namespace = "com.sadri.composemovie.designsystem"
    compileSdk = Android.compileSdkVersion

    defaultConfig {
        minSdk = Android.minSdkVersion
        targetSdk = Android.targetSdkVersion
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.kotlinCompilerExtensionVersion
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":library:core"))

    implementation(Libs.Common.composeMaterial3)
    implementation(Libs.Common.composeMaterial)
    implementation(Libs.Common.composeUi)
    implementation(Libs.Common.composeCompiler)
    implementation(Libs.Common.paging)
    implementation(Libs.Common.composeLifecycle)
    implementation(Libs.Common.composeActivity)
    implementation(Libs.Common.composeRuntime)

    implementation(Libs.Common.imageLoader)
    implementation(Libs.Common.imageLoaderPlaceHolder)

    implementation(Libs.Common.performance)
}