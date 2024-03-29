package ch03.fib;

import java.util.UUID;
import java.util.Set;
import java.util.Iterator;
import java.util.Locale;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPConstants;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.Name;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
//import javax.xml.ws.soap.SOAPFaultException;
import java.io.IOException;

public class UUIDValidator implements SOAPHandler<SOAPMessageContext> {
    public boolean handleMessage(SOAPMessageContext ctx) {
	// Is this an inbound message, i.e., a request?
	Boolean response_p = (Boolean)
            ctx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

	// Manipulate the SOAP only if it's incoming.
        if (!response_p) {
	    try {
		SOAPMessage msg = ctx.getMessage();
		SOAPEnvelope env = msg.getSOAPPart().getEnvelope();
		SOAPHeader hdr = env.getHeader();

		// Ensure that the SOAP message has a header.
		if (hdr == null) {
		    generateSOAPFault(msg, "No message header.");
		    return true;
		}

		Name lookup_name = create_qname(msg);
    		Iterator it = hdr.getChildElements(lookup_name);
		Node next = (Node) it.next();
		String value = (next == null) ? null : next.getValue();
		if (value == null) {
		    generateSOAPFault(msg, "No UUID header block.");
		    return true;
		}

		UUID uuid = UUID.fromString(value.trim());
		if (uuid.variant() != UUIDvariant ||
		    uuid.version() != UUIDversion) {
		    generateSOAPFault(msg, "Bad variant or version.");
		    return true;
		}

		// For tracking, write to standard output.
		msg.writeTo(System.out);
	    }
	    catch(SOAPException e) { System.err.println(e); }
	    catch(IOException e) { System.err.println(e); }
	}
        return true; // continue down the chain
    }
    
    public boolean handleFault(SOAPMessageContext ctx) {
        return false; // do not continue down the chain
    }

    // For now, no-ops. 
    public Set<QName> getHeaders() { return null; }     
    public void close(MessageContext messageContext) { }

    private void generateSOAPFault(SOAPMessage msg, String reason) {
	try {
	    SOAPBody body = msg.getSOAPBody();
	    SOAPFault fault = body.addFault();
	    QName fault_name = 
		new QName(SOAPConstants.URI_NS_SOAP_1_2_ENVELOPE, 
			  "UltimateReceiver");
	    fault.setFaultCode(fault_name);
	    fault.setFaultRole("http://ch03.fib/uuid_validator");
	    fault.addFaultReasonText(reason, Locale.US);
	}
	catch(SOAPException e) { }
    }
    private Name create_qname(SOAPMessage msg) {
       Name name = null;
       try {
         SOAPEnvelope env = msg.getSOAPPart().getEnvelope();
         name = env.createName(LocalName);
       }
       catch(SOAPException e) { System.err.println(e); }
       return name;
    }
    
    private static final String LocalName = "uuid";
    private static final int UUIDvariant = 2; // layout
    private static final int UUIDversion = 4; // version 
}
