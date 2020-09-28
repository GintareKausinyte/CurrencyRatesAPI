package lt.internship.currencyConverter.entities;

import lombok.Data;
import lt.internship.currencyConverter.integration.xmlEntities.CcyAmt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
//@Entity
public class FxRateDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Tp;
    private String Dt;
    private List<CcyAmt> CcyAmt;

}
