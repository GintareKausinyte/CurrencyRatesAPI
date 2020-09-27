package lt.internship.currencyConverter.integration.xmlEntities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@Data
@XmlAccessorType (XmlAccessType.FIELD)
public class FxRates implements Serializable {
   @XmlElement(name = "FxRate", required = true)
   protected List<FxRates> FxRate;


}
