plugins {
  id(Plugins.androidApplication)
  id(Plugins.kotlinAndroid)
  id(Plugins.kotlinKapt)
  id(Plugins.kotlinParcelize)
}

android {
  namespace = "com.sadri.composemovie.core"
  compileSdk = Android.compileSdkVersion

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
  implementation(Libs.Common.kotlinLib)
  implementation(Libs.Common.coroutines)
  implementation(Libs.Common.coroutinesAndroid)

  implementation(Libs.Common.coreKtx)
}