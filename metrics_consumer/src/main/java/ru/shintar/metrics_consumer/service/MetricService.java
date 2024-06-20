package ru.shintar.metrics_consumer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shintar.metrics_consumer.model.MetricDataDTO;
import ru.shintar.metrics_consumer.repository.MetricDataRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MetricService {
    private final MetricDataRepository repository;

    public List<MetricDataDTO> getAllMetric() {
        return repository.findAll();
    }

    public MetricDataDTO findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void saveMetric(MetricDataDTO metricDataDTO) {
        repository.save(metricDataDTO);
    }
}
