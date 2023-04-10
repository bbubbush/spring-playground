package com.bbubbush.springplayground.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HealthInfoExcelService {

    public List<Map<String, String>> toMapFromLocalFile(String path) {
        return readFile(path)
                .stream()
                .skip(1)
                .map(text -> this.parseToString(text))
                .collect(Collectors.toList());


    }
    private List<String> readFile(String path) {
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String, String> parseToString(String text) {
        String[] splitHealthInfo = text.split(",");
        int idx = 0;
        Map<String, String> healthInfo = new HashMap<>();
        healthInfo.put("year", splitHealthInfo[idx++]);
        healthInfo.put("seq", splitHealthInfo[idx++]);
        healthInfo.put("cityCode", splitHealthInfo[idx++]);
        healthInfo.put("gender", splitHealthInfo[idx++]);
        healthInfo.put("age", splitHealthInfo[idx++]);
        healthInfo.put("height", splitHealthInfo[idx++]);
        healthInfo.put("weight", splitHealthInfo[idx++]);
        healthInfo.put("waistCircumference", splitHealthInfo[idx++]);
        healthInfo.put("leftEyeVision", splitHealthInfo[idx++]);
        healthInfo.put("rightEyeVision", splitHealthInfo[idx++]);
        healthInfo.put("leftHearing", splitHealthInfo[idx++]);
        healthInfo.put("rightHearing", splitHealthInfo[idx++]);
        healthInfo.put("systolicBloodPressure", splitHealthInfo[idx++]);
        healthInfo.put("diastolicBloodPressure", splitHealthInfo[idx++]);
        // TODO 이후 데이터는 일단 생략
        return healthInfo;
    }
}
