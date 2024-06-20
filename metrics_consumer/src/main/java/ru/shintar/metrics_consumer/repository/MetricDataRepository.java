package ru.shintar.metrics_consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shintar.metrics_consumer.model.MetricDataDTO;

public interface MetricDataRepository extends JpaRepository<MetricDataDTO, Long> {
}
