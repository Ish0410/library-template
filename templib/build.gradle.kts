plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)

    // maven central repository
    // alias(libs.plugins.vanniktech.maven.publish)
    // id("signing")

    // jitpack
    // id("maven-publish")
}

android {
    namespace = "com.example.templib"
    compileSdk = 34

    defaultConfig {
        minSdk = 29
        //targetSdk = 34  deprecated

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

// jitpack 전용 코드 (github 저장소 배포 전용)
// afterEvaluate {
//     publishing {
//         publications {
//             create<MavenPublication>("release") {
//                 from(components["release"])
//
//                 groupId = "com.github.mmol93"
//                 artifactId = "TestLibrary"
//                 version = "1.0.0"
//             }
//             create<MavenPublication>("debug") {
//                 from(components["debug"])
//
//                 groupId = "com.github.mmol93"
//                 artifactId = "TestLibrary"
//                 version = "1.0.0"
//             }
//         }
//     }
// }