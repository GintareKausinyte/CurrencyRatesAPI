package lt.internship.currencyConverter.entities;

import lombok.Data;
import lt.internship.currencyConverter.integration.xmlEntities.FxRate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
//@Entity
public class FxRatesDto {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private List<FxRate> FxRate;


}
