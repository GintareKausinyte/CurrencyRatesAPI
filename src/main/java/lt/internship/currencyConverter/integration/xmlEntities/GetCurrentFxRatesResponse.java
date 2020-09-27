package lt.internship.currencyConverter.integration.xmlEntities;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@Data
@XmlRootElement(namespace = "http://www.lb.lt/WebServices/FxRates", name = "getCurrentFxRatesResponse")
public class GetCurrentFxRatesResponse {
    @XmlElement(name = "getCurrentFxRatesResult")
    List<GetCurrentFxRatesResult> getCurrentFxRatesResult;
}
