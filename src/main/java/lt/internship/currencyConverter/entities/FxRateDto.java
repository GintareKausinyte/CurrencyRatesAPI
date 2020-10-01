package lt.internship.currencyConverter.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "FxRateDto")
public class FxRateDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String date;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<CcyAmtDto> currencyAmountList;
}
