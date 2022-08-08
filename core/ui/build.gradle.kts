plugins {
    id("top100albums.android.library")
    id("top100albums.android.library.compose")
}

dependencies {
    implementation(Libs.androidx_coreKtx)
    api(Libs.androidx_compose_foundation)
    api(Libs.androidx_compose_foundation_layout)
    api(Libs.androidx_compose_material)

    debugApi(Libs.androidx_compose_ui_tooling)
    api(Libs.androidx_compose_ui_tooling_preview)
    api(Libs.androidx_compose_ui_util)
    api(Libs.androidx_compose_ui_unit)
    api(Libs.androidx_compose_runtime)

    debugImplementation(Libs.androidx_customview_poolingcontainer)
}