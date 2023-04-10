package com.bbubbush.springplayground.runner;

import com.bbubbush.springplayground.service.HealthInfoExcelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
@Order(3)
public class HealthInfoExcelAppRunner implements CommandLineRunner {
    private final HealthInfoExcelService healthInfoExcelService;

    @Override
    public void run(String... args) {
        List<Map<String, String>> healthInfo = healthInfoExcelService.toMapFromLocalFile("simple-healthcare.csv");
        //log.debug("healthInfo ::  {}",  healthInfo);
        // 1. 남녀의 평균 신장, 평균 몸무게 구하기
        Double averageHeightOfMales = healthInfo.stream()
                .filter(health -> health.get("gender").equals("1"))
                .mapToInt(health -> Integer.parseInt(health.get("height")))
                .average()
                .orElse(0);
        log.debug("남자의 평균 신장 :: {}", averageHeightOfMales);

        Double averageWeightOfMales = healthInfo.stream()
                .filter(health -> health.get("gender").equals("1"))
                .mapToInt(health -> Integer.parseInt(health.get("weight")))
                .average()
                .orElse(0);
        log.debug("남자의 평균 몸무게 :: {}", averageWeightOfMales);

        Double averageHeightOfFemales = healthInfo.stream()
                .filter(health -> health.get("gender").equals("2"))
                .mapToInt(health -> Integer.parseInt(health.get("height")))
                .average()
                .orElse(0);
        log.debug("여자의 평균 신장 :: {}", averageHeightOfFemales);

        Double averageWeightOfFemales = healthInfo.stream()
                .filter(health -> health.get("gender").equals("2"))
                .mapToInt(health -> Integer.parseInt(health.get("weight")))
                .average()
                .orElse(0);
        log.debug("여자의 평균 몸무게 :: {}", averageWeightOfFemales);


        // 2. 고혈압 대상 구하기
        long numberOfHighBloodPressure = healthInfo.stream()
                .filter(health -> {
                    int systolicBloodPressure = Integer.parseInt(health.get("systolicBloodPressure"));
                    int diastolicBloodPressure = Integer.parseInt(health.get("diastolicBloodPressure"));
                    if (systolicBloodPressure >= 140 || diastolicBloodPressure >= 90) {
                        return true;
                    }
                    return false;
                })
                .count();
        log.debug("고혈압 환자의 수 :: {}", numberOfHighBloodPressure);
    }


    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int totalComputers = Integer.parseInt(br.readLine());
        int totalNetworks = Integer.parseInt(br.readLine());
        List<String> networks = new ArrayList<>();
        for (int i = 0; i < totalNetworks; i++) {
            networks.add(br.readLine());
        }

        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        while (!queue.isEmpty()) {
            String target = queue.poll();
            networks = networks.stream().filter(network -> {
                String[] link = network.split(" ");
                if (link[0].equals(target)) {
                    queue.add(link[1]);
                    return false;
                }
                return true;
            })
            .collect(Collectors.toList());


        }

    }
}
