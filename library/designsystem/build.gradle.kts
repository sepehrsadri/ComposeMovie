import com.android.build.gradle.internal.tasks.factory.dependsOn

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
    implementation("androidx.compose.runtime:runtime:1.4.3")//specify the version

    implementation(Libs.Common.composeMaterial3)
    implementation(Libs.Common.composeMaterial)
    implementation(Libs.Common.composeUi)
    implementation(Libs.Common.composeRunTime)
    implementation(Libs.Common.paging)
    implementation(Libs.Common.composeLifecycle)
    implementation(Libs.Common.composeActivity)

    implementation(Libs.Common.imageLoader)
    implementation(Libs.Common.imageLoaderPlaceHolder)

    implementation(Libs.Common.performance)
}