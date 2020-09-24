package lt.internship.currencyConverter.integration.xmlEntities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@Data
@XmlRootElement
public class FxRate {
    @XmlElement(name = "Tp", required=true)
    protected Enum Tp;
    @XmlElement(name = "Dt", required=true)
    protected String Dt;
    @XmlElement(name = "CcyAmt", required=true)
    protected List<CcyAmt> CcyAmt;

}
