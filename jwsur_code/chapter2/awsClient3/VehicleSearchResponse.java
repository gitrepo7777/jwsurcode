
package awsClient3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://webservices.amazon.com/AWSECommerceService/2008-10-06}OperationRequest" minOccurs="0"/>
 *         &lt;element ref="{http://webservices.amazon.com/AWSECommerceService/2008-10-06}VehicleYears" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "operationRequest",
    "vehicleYears"
})
@XmlRootElement(name = "VehicleSearchResponse")
public class VehicleSearchResponse {

    @XmlElement(name = "OperationRequest")
    protected OperationRequest operationRequest;
    @XmlElement(name = "VehicleYears")
    protected List<VehicleYears> vehicleYears;

    /**
     * Gets the value of the operationRequest property.
     * 
     * @return
     *     possible object is
     *     {@link OperationRequest }
     *     
     */
    public OperationRequest getOperationRequest() {
        return operationRequest;
    }

    /**
     * Sets the value of the operationRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationRequest }
     *     
     */
    public void setOperationRequest(OperationRequest value) {
        this.operationRequest = value;
    }

    /**
     * Gets the value of the vehicleYears property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vehicleYears property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVehicleYears().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehicleYears }
     * 
     * 
     */
    public List<VehicleYears> getVehicleYears() {
        if (vehicleYears == null) {
            vehicleYears = new ArrayList<VehicleYears>();
        }
        return this.vehicleYears;
    }

}
