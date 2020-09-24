package lt.internship.currencyConverter.integration.xmlEntities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(namespace = "http://www.lb.lt/WebServices/FxRates", name = "FxRates")
public class FxRates {
   @XmlElement(name = "FxRate", required = true)
    protected List<FxRates> FxRate;


}
