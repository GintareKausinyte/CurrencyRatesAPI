package lt.internship.currencyConverter.integration.xmlEntities;

import lombok.Data;
import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement(namespace = "http://www.lb.lt/WebServices/FxRates", name = "FxRates")
public class FxRates {
   @XmlElement(name = "FxRate")
   protected List<FxRate> FxRate;
}
