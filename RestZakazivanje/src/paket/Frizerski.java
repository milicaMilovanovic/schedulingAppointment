package paket;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.5-jbossorg-1
 * 2019-06-28T19:27:56.261+02:00
 * Generated source version: 3.2.5-jbossorg-1
 *
 */
@WebService(targetNamespace = "http://www.example.org/Frizerski/", name = "Frizerski")
@XmlSeeAlso({ObjectFactory.class})
public interface Frizerski {

    @WebMethod
    @RequestWrapper(localName = "slobodniTerminiFrizera", targetNamespace = "http://www.example.org/Frizerski/", className = "paket.SlobodniTerminiFrizera")
    @ResponseWrapper(localName = "slobodniTerminiFrizeraResponse", targetNamespace = "http://www.example.org/Frizerski/", className = "paket.SlobodniTerminiFrizeraResponse")
    @WebResult(name = "out", targetNamespace = "")
    public java.util.List<paket.TerminType> slobodniTerminiFrizera(
        @WebParam(name = "in", targetNamespace = "")
        int in
    );

    @WebMethod
    @RequestWrapper(localName = "zakaziTermin", targetNamespace = "http://www.example.org/Frizerski/", className = "paket.ZakaziTermin")
    @ResponseWrapper(localName = "zakaziTerminResponse", targetNamespace = "http://www.example.org/Frizerski/", className = "paket.ZakaziTerminResponse")
    @WebResult(name = "out", targetNamespace = "")
    public boolean zakaziTermin(
        @WebParam(name = "in", targetNamespace = "")
        paket.TerminType in
    );

    @WebMethod(action = "http://www.example.org/Frizerski/terminiMusterije")
    @RequestWrapper(localName = "terminiMusterije", targetNamespace = "http://www.example.org/Frizerski/", className = "paket.TerminiMusterije")
    @ResponseWrapper(localName = "terminiMusterijeResponse", targetNamespace = "http://www.example.org/Frizerski/", className = "paket.TerminiMusterijeResponse")
    @WebResult(name = "out", targetNamespace = "")
    public java.util.List<paket.TerminType> terminiMusterije(
        @WebParam(name = "in", targetNamespace = "")
        int in
    );

    @WebMethod
    @RequestWrapper(localName = "vratiSveFrizere", targetNamespace = "http://www.example.org/Frizerski/", className = "paket.VratiSveFrizere")
    @ResponseWrapper(localName = "vratiSveFrizereResponse", targetNamespace = "http://www.example.org/Frizerski/", className = "paket.VratiSveFrizereResponse")
    @WebResult(name = "out", targetNamespace = "")
    public java.util.List<paket.FrizerType> vratiSveFrizere(
        @WebParam(name = "in", targetNamespace = "")
        java.lang.String in
    );
}
