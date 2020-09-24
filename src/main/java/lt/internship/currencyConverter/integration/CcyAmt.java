package lt.internship.currencyConverter.integration;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;

@Getter
@Setter
public class CcyAmt {
    @XmlElement(name = "Ccy")
    protected String Ccy;
    @XmlElement(name = "Amt")
    protected String Amt;
}
