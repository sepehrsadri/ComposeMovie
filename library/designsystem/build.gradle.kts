import com.android.build.gradle.internal.tasks.factory.dependsOn

plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
}

android {
    namespace = "com.sadri.composemovie.designsystem"
    compileSdk = Android.compileSdkVersion
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.kotlinCompilerExtensionVersion
    }
}

dependencies {

    implementation(Libs.Common.coreKtx)
    implementation(Libs.Common.composeMaterial3)
    implementation(Libs.Common.composeMaterial)
    implementation(Libs.Common.composeUi)
    implementation(Libs.Common.composeRunTime)
    implementation(Libs.Common.composeUiToolingPreview)
    debugImplementation(Libs.Common.composeUiTooling)
    implementation(Libs.Common.composeUiToolingPreview)
    implementation(Libs.Common.paging)
    implementation(Libs.Common.composeLifecycle)
    implementation(Libs.Common.composeActivity)

    implementation(Libs.Common.systemUiController)

    implementation(Libs.Common.imageLoader)
    implementation(Libs.Common.imageLoaderPlaceHolder)

    implementation(Libs.Common.performance)
}