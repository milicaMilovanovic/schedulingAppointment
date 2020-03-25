
package paket;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FrizuraType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FrizuraType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="farbanje" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="feniranje" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="sisanje" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
@XmlType(name = "FrizuraType", propOrder = {
    "id",
    "farbanje",
    "feniranje",
    "sisanje",
    "termini"
})
public class FrizuraType {

    protected int id;
    protected boolean farbanje;
    protected boolean feniranje;
    protected boolean sisanje;
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
     * Gets the value of the farbanje property.
     * 
     */
    public boolean isFarbanje() {
        return farbanje;
    }

    /**
     * Sets the value of the farbanje property.
     * 
     */
    public void setFarbanje(boolean value) {
        this.farbanje = value;
    }

    /**
     * Gets the value of the feniranje property.
     * 
     */
    public boolean isFeniranje() {
        return feniranje;
    }

    /**
     * Sets the value of the feniranje property.
     * 
     */
    public void setFeniranje(boolean value) {
        this.feniranje = value;
    }

    /**
     * Gets the value of the sisanje property.
     * 
     */
    public boolean isSisanje() {
        return sisanje;
    }

    /**
     * Sets the value of the sisanje property.
     * 
     */
    public void setSisanje(boolean value) {
        this.sisanje = value;
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
