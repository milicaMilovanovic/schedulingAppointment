
package paketSminkerski;

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
 *         &lt;element name="musterija" type="{http://www.example.org/SminkerskiSalon/}MusterijaType"/&gt;
 *         &lt;element name="sminker" type="{http://www.example.org/SminkerskiSalon/}SminkerType"/&gt;
 *         &lt;element name="komentar" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "musterija",
    "sminker",
    "komentar"
})
public class TerminType {

    protected int id;
    @XmlElement(required = true)
    protected String datum;
    @XmlElement(required = true)
    protected MusterijaType musterija;
    @XmlElement(required = true)
    protected SminkerType sminker;
    @XmlElement(required = true)
    protected String komentar;

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
     * Gets the value of the sminker property.
     * 
     * @return
     *     possible object is
     *     {@link SminkerType }
     *     
     */
    public SminkerType getSminker() {
        return sminker;
    }

    /**
     * Sets the value of the sminker property.
     * 
     * @param value
     *     allowed object is
     *     {@link SminkerType }
     *     
     */
    public void setSminker(SminkerType value) {
        this.sminker = value;
    }

    /**
     * Gets the value of the komentar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKomentar() {
        return komentar;
    }

    /**
     * Sets the value of the komentar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKomentar(String value) {
        this.komentar = value;
    }

}
