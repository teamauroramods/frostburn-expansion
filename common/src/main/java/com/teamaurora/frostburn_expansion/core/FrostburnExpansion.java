package com.teamaurora.frostburn_expansion.core;

import gg.moonflower.pollen.api.platform.Platform;

public class  FrostburnExpansion {
    public static final String MOD_ID = "frostburn_expansion";
    public static final Platform PLATFORM = Platform.builder(MOD_ID)
            .clientInit(FrostburnExpansion::onClientInit)
            .clientPostInit(FrostburnExpansion::onClientPostInit)
            .commonInit(FrostburnExpansion::onCommonInit)
            .commonPostInit(FrostburnExpansion::onCommonPostInit)
            .dataInit(FrostburnExpansion::onDataInit)
            .build();

    public static void onClientInit() {
    }

    public static void onClientPostInit(Platform.ModSetupContext ctx) {
    }

    public static void onCommonInit() {
    }

    public static void onCommonPostInit(Platform.ModSetupContext ctx) {
    }

    public static void onDataInit(Platform.DataSetupContext ctx) {
    }
}
