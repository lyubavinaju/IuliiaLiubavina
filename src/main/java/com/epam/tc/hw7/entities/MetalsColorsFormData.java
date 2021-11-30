package com.epam.tc.hw7.entities;

import lombok.Getter;

@Getter
public class MetalsColorsFormData {
    private String vegetablesSelectedByDefault;
    private String customRadioOdd;
    private String customRadioEven;
    private String colors;
    private String metals;
    private String[] vegetables;
    private String[] elements;

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
}
