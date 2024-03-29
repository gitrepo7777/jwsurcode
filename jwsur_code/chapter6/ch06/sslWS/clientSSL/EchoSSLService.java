
package clientSSL;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.1 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "EchoSSLService", targetNamespace = "http://sslWS.ch06/", wsdlLocation = "http://localhost:8081/EchoSSLService/EchoSSL?wsdl")
public class EchoSSLService
    extends Service
{

    private final static URL ECHOSSLSERVICE_WSDL_LOCATION;

    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8081/EchoSSLService/EchoSSL?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ECHOSSLSERVICE_WSDL_LOCATION = url;
    }

    public EchoSSLService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EchoSSLService() {
        super(ECHOSSLSERVICE_WSDL_LOCATION, new QName("http://sslWS.ch06/", "EchoSSLService"));
    }

    /**
     * 
     * @return
     *     returns EchoSSL
     */
    @WebEndpoint(name = "EchoSSLPort")
    public EchoSSL getEchoSSLPort() {
        return (EchoSSL)super.getPort(new QName("http://sslWS.ch06/", "EchoSSLPort"), EchoSSL.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EchoSSL
     */
    @WebEndpoint(name = "EchoSSLPort")
    public EchoSSL getEchoSSLPort(WebServiceFeature... features) {
        return (EchoSSL)super.getPort(new QName("http://sslWS.ch06/", "EchoSSLPort"), EchoSSL.class, features);
    }

}
