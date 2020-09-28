package lt.internship.currencyConverter.integration.xmlEntities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@Data
//@XmlAccessorType (XmlAccessType.FIELD)
@XmlRootElement(namespace = "http://www.lb.lt/WebServices/FxRates", name = "FxRates")
public class FxRates {

   @XmlElement(name = "FxRate")
   protected List<FxRate> FxRate;


}
