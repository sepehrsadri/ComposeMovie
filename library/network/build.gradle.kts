plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.hilt)
}

android {
    namespace = "com.sadri.composemovie.network"
    compileSdk = Android.compileSdkVersion

    defaultConfig {
        minSdk = Android.minSdkVersion
        targetSdk = Android.targetSdkVersion
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
    implementation(Libs.Common.hilt)
    kapt(Libs.Common.hiltCompiler)
    implementation(Libs.Common.hiltBinder)
    kapt(Libs.Common.hiltBinderCompiler)

    implementation(Libs.Common.dataStore)

    api(Libs.Common.retrofit)
    api(Libs.Common.gson)
    implementation(Libs.Common.retrofitGsonConverter)
    implementation(Libs.Common.okHttpInterceptor)
    implementation(Libs.Common.okhttp)
    debugImplementation(Libs.Common.chucker)
    releaseImplementation(Libs.Common.chuckerRelease)
}