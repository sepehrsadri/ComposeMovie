plugins {
  id(Plugins.androidLibrary)
  id(Plugins.kotlinAndroid)
  id(Plugins.kotlinKapt)
  id(Plugins.kotlinParcelize)
}

android {
  namespace = "com.sadri.composemovie.core"
  compileSdk = Android.compileSdkVersion

  defaultConfig {
    minSdk = Android.minSdkVersion
    targetSdk = Android.targetSdkVersion
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }

  kotlinOptions {
    jvmTarget = JavaVersion.VERSION_11.toString()
  }

  buildFeatures {
    compose = true
  }

  composeOptions {
    kotlinCompilerExtensionVersion = Versions.kotlinCompilerExtensionVersion
  }
}

dependencies {
  implementation(Libs.Common.kotlinLib)
  implementation(Libs.Common.coroutines)
  implementation(Libs.Common.coroutinesAndroid)
  implementation(Libs.Common.composeRuntime)

  api(Libs.Common.gson)
  implementation(Libs.Common.annotation)
  implementation(Libs.Common.retrofit)
}