package lt.internship.currencyConverter.integration.xmlEntities;

import lombok.Data;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class FxRate {
   @XmlElement(name = "Tp", required=true)
    protected String Tp;
   @XmlElement(name = "Dt", required=true)
    protected String Dt;
   @XmlElement(name = "CcyAmt", required=true)
    protected List<CcyAmt> CcyAmt;

}
