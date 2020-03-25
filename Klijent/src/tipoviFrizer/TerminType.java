
package tipoviFrizer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TerminType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TerminType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="frizer" type="{http://www.example.org/Frizerski/}FrizerType"/&gt;
 *         &lt;element name="musterija" type="{http://www.example.org/Frizerski/}MusterijaType"/&gt;
 *         &lt;element name="frizura" type="{http://www.example.org/Frizerski/}FrizuraType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TerminType", propOrder = {
    "id",
    "datum",
    "frizer",
    "musterija",
    "frizura"
})
public class TerminType {

    protected int id;
    @XmlElement(required = true)
    protected String datum;
    @XmlElement(required = true)
    protected FrizerType frizer;
    @XmlElement(required = true)
    protected MusterijaType musterija;
    @XmlElement(required = true)
    protected FrizuraType frizura;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatum(String value) {
        this.datum = value;
    }

    /**
     * Gets the value of the frizer property.
     * 
     * @return
     *     possible object is
     *     {@link FrizerType }
     *     
     */
    public FrizerType getFrizer() {
        return frizer;
    }

    /**
     * Sets the value of the frizer property.
     * 
     * @param value
     *     allowed object is
     *     {@link FrizerType }
     *     
     */
    public void setFrizer(FrizerType value) {
        this.frizer = value;
    }

    /**
     * Gets the value of the musterija property.
     * 
     * @return
     *     possible object is
     *     {@link MusterijaType }
     *     
     */
    public MusterijaType getMusterija() {
        return musterija;
    }

    /**
     * Sets the value of the musterija property.
     * 
     * @param value
     *     allowed object is
     *     {@link MusterijaType }
     *     
     */
    public void setMusterija(MusterijaType value) {
        this.musterija = value;
    }

    /**
     * Gets the value of the frizura property.
     * 
     * @return
     *     possible object is
     *     {@link FrizuraType }
     *     
     */
    public FrizuraType getFrizura() {
        return frizura;
    }

    /**
     * Sets the value of the frizura property.
     * 
     * @param value
     *     allowed object is
     *     {@link FrizuraType }
     *     
     */
    public void setFrizura(FrizuraType value) {
        this.frizura = value;
    }

}
