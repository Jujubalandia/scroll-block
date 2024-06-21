package com.vishal2376.scrollblock.presentation.onboarding


val instructionSteps = listOf(
    "Step 1: Go to Accessibility Settings",
    "Step 2: Select Downloaded Apps",
    "Step 3: Find Scroll Block",
    "Step 4: Enable Accessibility Service"
)

data class OptionalSettings(
    val title: String, val reason: String
)

val optionalSettings = listOf(
    OptionalSettings(
        "Turn off Battery Optimization",
        "Disabling battery optimization ensures that our app runs smoothly in the background without being interrupted"
    ),
    OptionalSettings(
        "Enable Auto Start",
        "Enabling auto start ensures that our app can start automatically when your device reboots, so you stay protected at all times"
    ),
)