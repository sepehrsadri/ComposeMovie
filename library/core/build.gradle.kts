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
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }

  kotlinOptions {
    jvmTarget = "17"
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
}