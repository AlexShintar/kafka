package ru.shintar.metrics_consumer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "metrics")
public class MetricDataDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty(value = "id")
    private Long id;

    @Column(name = "name")
    @JsonProperty(value = "name")
    private String name;

    @Column(name = "value")
    @JsonProperty(value = "data")
    private double value;

    @Column(name = "description")
    @JsonProperty(value = "description")
    private String description;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public MetricDataDTO(SomeMetricData someMetricData) {
        this.name = someMetricData.getName();
        this.value = someMetricData.getValue();
        this.description = someMetricData.getDescription();
    }
}


