import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import java.net.HttpURLConnection;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.MalformedURLException;
import java.security.cert.Certificate;
import java.io.InputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.xml.ws.BindingProvider;

class SecureClientRC2 {
    private static final String url_s = "https://localhost:9876/fib";

    // Send a GET request and print the response status code.
    public static void main(String[ ] args) {
	new SecureClientRC2().do_it();
    }

    private void do_it() {
	try {
	    // Create a context that doesn't check certificates.
	    SSLContext ssl_ctx = SSLContext.getInstance("TLS");
	    TrustManager[ ] trust_mgr = get_trust_mgr(); 
	    ssl_ctx.init(null,                // key manager
			 trust_mgr,           // trust manager
			 new SecureRandom()); // random number generator
	    HttpsURLConnection.setDefaultSSLSocketFactory(ssl_ctx.getSocketFactory());

	    URL url = new URL(url_s);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
	    // Guard against "bad hostname" errors during handshake.
	    conn.setHostnameVerifier(new HostnameVerifier() {
		    public boolean verify(String host, SSLSession session) {
			return true;
		    }
		});
            conn.setDoInput(true);
	    conn.setDoOutput(true);

	    conn.setRequestMethod("GET");

	    conn.addRequestProperty(BindingProvider.USERNAME_PROPERTY, "fred");
	    conn.addRequestProperty(BindingProvider.PASSWORD_PROPERTY, "rockbed");

	    conn.connect();
	    dump_features(conn);
	    
	    byte[ ] buffer = new byte[2048];
	    InputStream in = conn.getInputStream();
	    in.read(buffer);
	    in.close();
	    System.out.println(new String(buffer));
	    
	}
	catch(MalformedURLException e) { System.err.println(e); }
	catch(IOException e) { e.printStackTrace(); }
	catch(Exception e) { System.err.println(e); }
    }

    private TrustManager[ ] get_trust_mgr() {
	// No exceptions thrown in any of the overridden methods.
	TrustManager[ ] certs = new TrustManager[ ] {
	    
	    new X509TrustManager() {
		public X509Certificate[ ] getAcceptedIssuers() {
		    return null; 
		}

		public void checkClientTrusted(X509Certificate[ ] certs, 
					       String type) { } 

		public void checkServerTrusted(X509Certificate[ ] certs, 
					       String type) { }
	    }
	};
	return certs;
    }

    private void dump_features(HttpsURLConnection conn) {
	try {
	    print("Status code:  " + conn.getResponseCode());
	    print("Cipher suite: " + conn.getCipherSuite());
	    Certificate[ ] certs = conn.getServerCertificates();
	    for (Certificate cert : certs) {
		print("\tCert. type: " + cert.getType());
		print("\tHash code:  " + cert.hashCode());
		print("\tAlgorithm:  " + cert.getPublicKey().getAlgorithm());
		print("\tFormat:     " + cert.getPublicKey().getFormat());
		print("");
	    }
	}
	catch(Exception e) { System.err.println(e); }
    }

    private void print(String s) {
	System.out.println(s);
    }
}

