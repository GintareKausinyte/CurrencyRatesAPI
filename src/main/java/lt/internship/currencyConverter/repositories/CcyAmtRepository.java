package lt.internship.currencyConverter.repositories;

import lt.internship.currencyConverter.entities.CcyAmtDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CcyAmtRepository extends JpaRepository<CcyAmtDto, Long> {
}
