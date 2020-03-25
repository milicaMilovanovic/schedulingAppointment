
package paket;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FrizerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FrizerType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="staz" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="termini" type="{http://www.example.org/Frizerski/}TerminType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FrizerType", propOrder = {
    "id",
    "ime",
    "prezime",
    "staz",
    "termini"
})
public class FrizerType {

    protected int id;
    @XmlElement(required = true)
    protected String ime;
    @XmlElement(required = true)
    protected String prezime;
    protected int staz;
    @XmlElement(nillable = true)
    protected List<TerminType> termini;

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
     * Gets the value of the ime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIme() {
        return ime;
    }

    /**
     * Sets the value of the ime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIme(String value) {
        this.ime = value;
    }

    /**
     * Gets the value of the prezime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Sets the value of the prezime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrezime(String value) {
        this.prezime = value;
    }

    /**
     * Gets the value of the staz property.
     * 
     */
    public int getStaz() {
        return staz;
    }

    /**
     * Sets the value of the staz property.
     * 
     */
    public void setStaz(int value) {
        this.staz = value;
    }

    /**
     * Gets the value of the termini property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the termini property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTermini().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TerminType }
     * 
     * 
     */
    public List<TerminType> getTermini() {
        if (termini == null) {
            termini = new ArrayList<TerminType>();
        }
        return this.termini;
    }

}
