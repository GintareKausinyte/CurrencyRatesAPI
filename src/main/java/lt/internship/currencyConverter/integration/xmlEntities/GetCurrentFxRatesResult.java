package lt.internship.currencyConverter.integration.xmlEntities;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class GetCurrentFxRatesResult {
    @XmlElement(name = "FxRates")
    List<FxRates> fxRates;
}
