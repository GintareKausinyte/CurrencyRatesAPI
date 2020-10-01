package lt.internship.currencyConverter.entities;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "CurrencyAmountDto")
public class CcyAmtDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String currency;
    private String amount;
}

