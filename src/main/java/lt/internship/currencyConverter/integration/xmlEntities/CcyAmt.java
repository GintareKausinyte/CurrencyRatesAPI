package lt.internship.currencyConverter.integration.xmlEntities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@Data
@XmlRootElement
public class CcyAmt {
    @XmlElement(name = "Ccy", required=true)
    protected String Ccy;
  @XmlElement(name = "Amt", required=true)
    protected BigDecimal Amt;
}