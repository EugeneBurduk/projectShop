package serviceSoap;



import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import java.net.MalformedURLException;
import java.net.URL;

@WebServiceClient(name = "ServiceSoapService",
        targetNamespace = "http://service/",
        wsdlLocation = "http://localhost:8083/price?wsdl")
public class ServiceSoap extends Service {

    public ServiceSoap(URL wsdlDocumentLocation, QName serviceName) {
        super(wsdlDocumentLocation, serviceName);
    }

    public ServiceSoap() throws MalformedURLException {
        super(new URL("http://localhost:8083/price?wsdl"),
                new QName("http://service/", "ServiceSoapService"));
    }

    @WebEndpoint(name = "ServiceSoapPort")
    public WebServiceSOAP getServiceSoapPort() {
        return (WebServiceSOAP)super.getPort(
                new QName("http://service/", "ServiceSoapPort"),
                WebServiceSOAP.class);
    }
}
