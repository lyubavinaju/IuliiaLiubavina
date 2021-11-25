package com.epam.tc.hw7.dataprovider;

import com.epam.tc.hw7.entities.MetalsColorsFormData;
import com.epam.tc.hw7.entities.ResultData;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.TreeSet;
import java.util.stream.IntStream;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.UncheckedIOException;
import org.testng.annotations.DataProvider;

public class TestData {

    public static final String JSON_FILE_PATH = "com/epam/tc/hw7/data/JDI_ex8_metalsColorsDataSet.json";
    public static final String VEGETABLES_SELECTED_BY_DEFAULT = "Vegetables";

    @DataProvider
    public static Object[][] metalsAndColorsFormData() {
        String content = readFile(JSON_FILE_PATH);
        JSONObject jsonObject = new JSONObject(content);
        TreeSet<String> testDataNames = new TreeSet<>(jsonObject.keySet());
        JSONArray jsonArray = new JSONArray();
        for (String name : testDataNames) {
            jsonArray.put(jsonObject.get(name));
        }
        Object[][] testData = new Object[jsonArray.length()][2];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject formDataJson = jsonArray.getJSONObject(i);

            JSONArray radio = formDataJson.getJSONArray("summary");
            JSONArray elementsJson = formDataJson.getJSONArray("elements");
            JSONArray vegetablesJson = formDataJson.getJSONArray("vegetables");
            String[] elements = IntStream.range(0, elementsJson.length())
                                         .boxed()
                                         .map(elementsJson::getString)
                                         .toArray(String[]::new);
            String[] vegetables = IntStream.range(0, vegetablesJson.length())
                                           .boxed()
                                           .map(vegetablesJson::getString)
                                           .toArray(String[]::new);

            MetalsColorsFormData formData = new MetalsColorsFormData()
                .setColors(formDataJson.getString("color"))
                .setMetals(formDataJson.getString("metals"))
                .setCustomRadioOdd(String.valueOf(radio.getInt(0)))
                .setCustomRadioEven(String.valueOf(radio.getInt(1)))
                .setElements(elements)
                .setVegetables(vegetables)
                .setVegetablesSelectedByDefault(VEGETABLES_SELECTED_BY_DEFAULT);
            ResultData resultData = new ResultData().setResult(formData);
            testData[i][0] = formData;
            testData[i][1] = resultData;
        }
        return testData;
    }

    private static String readFile(String jsonFilePath) {
        try {
            URL resource = TestData.class.getClassLoader().getResource(jsonFilePath);
            if (resource == null) {
                throw new FileNotFoundException();
            }
            return Files.readString(Path.of(resource.getPath()), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
