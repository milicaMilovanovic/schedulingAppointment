package paket;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.5-jbossorg-1
 * 2019-06-28T19:27:56.328+02:00
 * Generated source version: 3.2.5-jbossorg-1
 *
 */
@WebServiceClient(name = "Frizerski",
                  wsdlLocation = "http://localhost:8080/FrizerskiSalon/Frizerski?wsdl",
                  targetNamespace = "http://www.example.org/Frizerski/")
public class Frizerski_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.example.org/Frizerski/", "Frizerski");
    public final static QName FrizerskiImplPort = new QName("http://www.example.org/Frizerski/", "FrizerskiImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/FrizerskiSalon/Frizerski?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(Frizerski_Service.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/FrizerskiSalon/Frizerski?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public Frizerski_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public Frizerski_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Frizerski_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    public Frizerski_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public Frizerski_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public Frizerski_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns Frizerski
     */
    @WebEndpoint(name = "FrizerskiImplPort")
    public Frizerski getFrizerskiImplPort() {
        return super.getPort(FrizerskiImplPort, Frizerski.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Frizerski
     */
    @WebEndpoint(name = "FrizerskiImplPort")
    public Frizerski getFrizerskiImplPort(WebServiceFeature... features) {
        return super.getPort(FrizerskiImplPort, Frizerski.class, features);
    }

}
