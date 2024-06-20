package ru.shintar.metrics_consumer.model;

import lombok.Data;
@Data
public class SomeMetricData {

    private String name;
    private double value;
    private String description;
}
