
package fibC;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.1 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "RabbitCounter", targetNamespace = "http://ch03.fib")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface RabbitCounter {


    /**
     * 
     * @param arg0
     * @return
     *     returns int
     * @throws FibException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "countRabbits", targetNamespace = "http://ch03.fib", className = "fibC.CountRabbits")
    @ResponseWrapper(localName = "countRabbitsResponse", targetNamespace = "http://ch03.fib", className = "fibC.CountRabbitsResponse")
    public int countRabbits(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws FibException_Exception
    ;

}
