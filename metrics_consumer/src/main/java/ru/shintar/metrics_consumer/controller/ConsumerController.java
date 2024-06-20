package ru.shintar.metrics_consumer.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ru.shintar.metrics_consumer.model.MetricDataDTO;
import ru.shintar.metrics_consumer.service.MetricService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/metrics")
public class ConsumerController {

    private final MetricService service;

    @GetMapping
    @Operation(summary = "Get all metrics", description = "Get a list of all metrics.", operationId = "getAllMetrics")
    public ResponseEntity<?> getAllMetrics() {
        List<MetricDataDTO> metricsDataList = service.getAllMetric();
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(metricsDataList);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get metric by id", description = "Get metric data by id.", operationId = "getMetricById")
    public ResponseEntity<?> getMetrics(@PathVariable Long id) {
        MetricDataDTO data = service.findById(id);
        if (data == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Metrics with id " + id + " not found");
        }
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(data);
    }
}
