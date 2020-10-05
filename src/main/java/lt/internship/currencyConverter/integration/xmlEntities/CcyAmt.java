package lt.internship.currencyConverter.integration.xmlEntities;

import lombok.Data;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class CcyAmt {
    @XmlElement(name = "Ccy", required = true)
    protected String Ccy;
    @XmlElement(name = "Amt", required = true)
    protected String Amt;
}
