
package awsClient;

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
@WebServiceClient(name = "AWSECommerceService", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2008-10-06", wsdlLocation = "http://ecs.amazonaws.com/AWSECommerceService/AWSECommerceService.wsdl")
public class AWSECommerceService
    extends Service
{

    private final static URL AWSECOMMERCESERVICE_WSDL_LOCATION;

    static {
        URL url = null;
        try {
            url = new URL("http://ecs.amazonaws.com/AWSECommerceService/AWSECommerceService.wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        AWSECOMMERCESERVICE_WSDL_LOCATION = url;
    }

    public AWSECommerceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AWSECommerceService() {
        super(AWSECOMMERCESERVICE_WSDL_LOCATION, new QName("http://webservices.amazon.com/AWSECommerceService/2008-10-06", "AWSECommerceService"));
    }

    /**
     * 
     * @return
     *     returns AWSECommerceServicePortType
     */
    @WebEndpoint(name = "AWSECommerceServicePort")
    public AWSECommerceServicePortType getAWSECommerceServicePort() {
        return (AWSECommerceServicePortType)super.getPort(new QName("http://webservices.amazon.com/AWSECommerceService/2008-10-06", "AWSECommerceServicePort"), AWSECommerceServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AWSECommerceServicePortType
     */
    @WebEndpoint(name = "AWSECommerceServicePort")
    public AWSECommerceServicePortType getAWSECommerceServicePort(WebServiceFeature... features) {
        return (AWSECommerceServicePortType)super.getPort(new QName("http://webservices.amazon.com/AWSECommerceService/2008-10-06", "AWSECommerceServicePort"), AWSECommerceServicePortType.class, features);
    }

}
