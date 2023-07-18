plugins {
  id(Plugins.androidLibrary)
  id(Plugins.kotlinAndroid)
  id(Plugins.kotlinKapt)
  id(Plugins.kotlinParcelize)
  id(Plugins.hilt)
  id(Plugins.composeCompilerHtmlReport) version Versions.composeCompilerHtmlReport
}

android {
  namespace = "com.sadri.composemovie.dashboard"
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
  implementation(project(":library:designsystem"))
  implementation(project(":library:network"))
  implementation(project(":library:core"))
  implementation(project(":feature:search"))

  implementation(Libs.Common.kotlinLib)
  implementation(Libs.Common.coroutines)
  implementation(Libs.Common.coroutinesAndroid)

  implementation(Libs.Common.coreKtx)
  implementation(Libs.Common.viewModelKtx)
  implementation(Libs.Common.liveDataKtx)
  implementation(Libs.Common.composeActivity)
  implementation(Libs.Common.composeUi)
  implementation(Libs.Common.composeCompiler)
  implementation(Libs.Common.composeRuntime)

  implementation(Libs.Common.performance)
  implementation(Libs.Common.tracing)

  implementation(Libs.Common.material)
  implementation(Libs.Common.composeMaterial3)
  implementation(Libs.Common.composeMaterial)
  implementation(Libs.Common.material3WindowSize)

  implementation(Libs.Common.hiltNavigationCompose)
  implementation(Libs.Common.navigation)
  implementation(Libs.Common.navigationKtx)

  implementation(Libs.Common.hilt)
  kapt(Libs.Common.hiltCompiler)

  implementation(Libs.Common.timber)

  testImplementation(Libs.Testing.junit)
  testImplementation(Libs.Testing.coroutinesTest)
  testImplementation(Libs.Testing.mockitoKotlin)
  testImplementation(Libs.Testing.testRunner)
  testImplementation(Libs.Testing.coreTesting)
  androidTestImplementation(Libs.Testing.testExtJunit)
}