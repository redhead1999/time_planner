plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    mavenLocal()
    gradlePluginPortal()
    google()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.20")
    implementation("com.android.tools.build:gradle:7.2.0")
    implementation("com.google.gms:google-services:4.3.15")
    implementation("com.google.firebase:firebase-crashlytics-gradle:2.9.5")
}

tasks.register("prepareKotlinBuildScriptModel"){}


