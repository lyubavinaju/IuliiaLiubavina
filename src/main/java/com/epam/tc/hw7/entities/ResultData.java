package com.epam.tc.hw7.entities;

import java.util.List;

public class ResultData {
    public List<String> result;

    public ResultData setResult(MetalsColorsFormData formData) {
        this.result = List.of(
            "Summary: " + (Integer.parseInt(formData.customRadioOdd) + Integer.parseInt(formData.customRadioEven)),
            "Elements: " + String.join(", ", formData.elements),
            "Color: " + formData.colors,
            "Metal: " + formData.metals,
            "Vegetables: " + String.join(", ", formData.vegetables));
        return this;
    }
}
