
package soap.countryws.client.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOftCountryCodeAndName", propOrder = {
    "tCountryCodeAndName"
})
public class ArrayOftCountryCodeAndName {

    @XmlElement(nillable = true)
    protected List<TCountryCodeAndName> tCountryCodeAndName;
    
    public List<TCountryCodeAndName> getTCountryCodeAndName() {
        if (tCountryCodeAndName == null) {
            tCountryCodeAndName = new ArrayList<TCountryCodeAndName>();
        }
        return this.tCountryCodeAndName;
    }

}
