plugins {
  id(Plugins.androidLibrary)
  id(Plugins.kotlinAndroid)
  id(Plugins.kotlinKapt)
  id(Plugins.hilt)
}

android {
  namespace = "com.sadri.composemovie.data"
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
  implementation(project(":library:core"))
  implementation(project(":library:network"))

  implementation(Libs.Common.hilt)
  kapt(Libs.Common.hiltCompiler)
  implementation(Libs.Common.hiltBinder)
  kapt(Libs.Common.hiltBinderCompiler)
}