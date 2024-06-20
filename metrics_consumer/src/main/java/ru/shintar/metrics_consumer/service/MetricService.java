package ru.shintar.metrics_consumer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shintar.metrics_consumer.model.MetricDataDTO;
import ru.shintar.metrics_consumer.repository.MetricDataRepository;

import java.util.List;

@Service
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
