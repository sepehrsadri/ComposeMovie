plugins {
  id(Plugins.androidLibrary)
  id(Plugins.kotlinAndroid)
}

android {
  namespace = "com.sadri.composemovie.testing"
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
  api(project(":library:core"))
  api(project(":library:domain"))
  api(project(":library:data"))

  api(Libs.Testing.junit)
  api(Libs.Testing.coroutinesTest)
  api(Libs.Testing.mockitoKotlin)
  api(Libs.Testing.testRunner)
  api(Libs.Testing.testExtJunit)
  api(Libs.Testing.coreTesting)
}