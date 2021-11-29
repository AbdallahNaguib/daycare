package com.example.daycare

import java.util.*

class Utils {
    companion object {
        // ex = nature_of_incident would return Nature of incident
        fun convertKeyToName(input: String?) =
            input?.replaceFirstChar {
                it.uppercase()
            }?.replace("_", " ")
    }
}