package lt.internship.currencyConverter.integration;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Getter
@Setter
public class FxRate {
    @XmlElement(name = "Dt")
    protected String Dt;
    @XmlElement(name = "CcyAmt")
    protected List<CcyAmt> CcyAmt;
    @XmlElement(name = "Tp")
    protected String Tp;

}
