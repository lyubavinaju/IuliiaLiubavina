package com.epam.tc.hw7.entities;

import java.util.List;

public class ResultData {
    public List<String> result;

    public ResultData setResult(MetalsColorsFormData formData) {
        this.result = List.of(
            "Summary: " + (Integer.parseInt(formData.getCustomRadioOdd()) + Integer
                .parseInt(formData.getCustomRadioEven())),
            "Elements: " + String.join(", ", formData.getElements()),
            "Color: " + formData.getColors(),
            "Metal: " + formData.getMetals(),
            "Vegetables: " + String.join(", ", formData.getVegetables()));
        return this;
    }
}
