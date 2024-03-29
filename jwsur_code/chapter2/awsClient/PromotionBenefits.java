
package awsClient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PromotionBenefits complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PromotionBenefits">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Benefit" type="{http://webservices.amazon.com/AWSECommerceService/2008-10-06}PromotionBenefit" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PromotionBenefits", propOrder = {
    "benefit"
})
public class PromotionBenefits {

    @XmlElement(name = "Benefit")
    protected List<PromotionBenefit> benefit;

    /**
     * Gets the value of the benefit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the benefit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBenefit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PromotionBenefit }
     * 
     * 
     */
    public List<PromotionBenefit> getBenefit() {
        if (benefit == null) {
            benefit = new ArrayList<PromotionBenefit>();
        }
        return this.benefit;
    }

}
