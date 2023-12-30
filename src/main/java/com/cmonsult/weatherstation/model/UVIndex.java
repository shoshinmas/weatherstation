package com.cmonsult.weatherstation.model;

public enum UVIndex {
    LOW("Low"),          // Represents 0 to 2
    MODERATE("Moderate"),// Represents 3 to 5
    HIGH("High"),        // Represents 6 to 7
    VERY_HIGH("Very High"), // Represents 8 to 10
    EXTREME("Extreme");  // Represents 11+

    private final String label;

    UVIndex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public static UVIndex fromString(String text) {
        for (UVIndex b : UVIndex.values()) {
            if (b.label.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null; // or throw exception
    }
}

