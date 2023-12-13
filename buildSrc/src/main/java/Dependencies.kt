object Dependencies {

    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val lifecycleRuntimeKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}" }
    val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.activityCompose}" }
    val composeBom by lazy { "androidx.compose:compose-bom:${Versions.composeBom}" }
    val composeUi by lazy { "androidx.compose.ui:ui" }
    val composeUiGraphics by lazy { "androidx.compose.ui:ui-graphics" }
    val composeUiToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview" }
    val composeMaterial3 by lazy { "androidx.compose.material3:material3" }
    val junit by lazy { "junit:junit:${Versions.junit}" }
    val junitExt by lazy { "androidx.test.ext:junit:${Versions.testExtJunit}" }
    val espressoCore by lazy { "androidx.test.espresso:espresso-core:${Versions.espressoCore}" }
    val composeUiTestJunit4 by lazy { "androidx.compose.ui:ui-test-junit4" }
    val composeUiTooling by lazy { "androidx.compose.ui:ui-tooling" }
    val composeUiTestManifest by lazy { "androidx.compose.ui:ui-test-manifest" }
    val navigationCompose = "androidx.navigation:navigation-compose:${Versions.navigationCompose}"

    val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
    val daggerHiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"

}

object Modules {
    const val utilities = ":utilities"
}