package lt.internship.currencyConverter.integration;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(namespace = "http://www.lb.lt/WebServices/FxRates", name = "FxRates")
//@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class FxRates {
   @XmlElement(name = "FxRate", required = true)
    protected List<FxRate> FxRate;
}
