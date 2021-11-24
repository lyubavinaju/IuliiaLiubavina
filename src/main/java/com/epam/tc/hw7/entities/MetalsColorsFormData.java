package com.epam.tc.hw7.entities;

import java.util.List;

public class MetalsColorsFormData {
    public String vegetablesSelectedByDefault;
    public String customRadioOdd;
    public String customRadioEven;
    public String colors;
    public String metals;
    public String[] vegetables;
    public String[] elements;
    public List<String> result;

    public MetalsColorsFormData setVegetablesSelectedByDefault(String vegetablesSelectedByDefault) {
        this.vegetablesSelectedByDefault = vegetablesSelectedByDefault;
        return this;
    }

    public MetalsColorsFormData setCustomRadioOdd(String customRadioOdd) {
        this.customRadioOdd = customRadioOdd;
        return this;
    }

    public MetalsColorsFormData setCustomRadioEven(String customRadioEven) {
        this.customRadioEven = customRadioEven;
        return this;
    }

    public MetalsColorsFormData setColors(String colors) {
        this.colors = colors;
        return this;
    }

    public MetalsColorsFormData setMetals(String metals) {
        this.metals = metals;
        return this;
    }

    public MetalsColorsFormData setVegetables(String[] vegetables) {
        this.vegetables = vegetables;
        return this;
    }

    public MetalsColorsFormData setElements(String[] elements) {
        this.elements = elements;
        return this;
    }

    public MetalsColorsFormData setResult() {
        this.result = List.of(
            "Summary: " + (Integer.parseInt(this.customRadioOdd) + Integer.parseInt(customRadioEven)),
            "Elements: " + String.join(", ", this.elements),
            "Color: " + colors,
            "Metal: " + metals,
            "Vegetables: " + String.join(", ", this.vegetables));
        return this;
    }
}
