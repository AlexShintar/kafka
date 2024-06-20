package ru.shintar.metrics_producer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shintar.metrics_producer.service.MetricsProducerService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/metrics")
@Tag(name = "Metrics Generate API", description = "API for generate metrica")
public class ProducerController {
    private final MetricsProducerService service;

    @PostMapping("")
    @Operation(summary = "Send Random generated metric", description = "Send Random generated metric", operationId = "sendRandomMetric")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successful operation"),
    })
    public ResponseEntity<String> sendRandomMetric() {
        service.sendRandom();
        return ResponseEntity.noContent().build();
    }
}
