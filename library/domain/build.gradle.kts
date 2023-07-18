plugins {
  id(Plugins.androidLibrary)
  id(Plugins.kotlinAndroid)
  id(Plugins.kotlinKapt)
  id(Plugins.hilt)
}

android {
  namespace = "com.sadri.composemovie.domain"
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
}

dependencies {
  implementation(project(":library:data"))

  implementation(Libs.Common.hilt)
  kapt(Libs.Common.hiltCompiler)
  implementation(Libs.Common.hiltBinder)
  kapt(Libs.Common.hiltBinderCompiler)
}