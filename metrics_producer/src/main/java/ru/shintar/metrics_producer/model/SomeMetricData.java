package ru.shintar.metrics_producer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SomeMetricData {

    @JsonProperty(value = "name", required = true)
    @NotEmpty
    private String name;

    @JsonProperty(value = "value", required = true)
    @NotBlank
    private double value;

    @JsonProperty(value = "description")
    private String description;

}
