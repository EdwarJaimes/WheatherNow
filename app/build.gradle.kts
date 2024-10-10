plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.theweathernow"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.theweathernow"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.retrofit)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // Add this line
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")
    implementation ("com.github.bumptech.glide:glide:4.14.2")
    implementation ("com.squareup.picasso:picasso:2.8")

}