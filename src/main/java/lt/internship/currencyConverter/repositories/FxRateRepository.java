package lt.internship.currencyConverter.repositories;

import lt.internship.currencyConverter.entities.FxRateDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FxRateRepository extends JpaRepository<FxRateDto, Long> {
}
