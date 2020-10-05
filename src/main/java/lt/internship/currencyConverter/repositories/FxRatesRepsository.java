package lt.internship.currencyConverter.repositories;

import lt.internship.currencyConverter.entities.FxRatesDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FxRatesRepsository extends JpaRepository<FxRatesDto, Long> {
}
