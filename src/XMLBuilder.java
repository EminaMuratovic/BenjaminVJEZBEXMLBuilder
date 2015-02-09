import java.io.DataOutputStream;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.URIResolver;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class XMLBuilder {
	
	public static void main(String[] args) throws ParserConfigurationException {
		DocumentBuilder docReader = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document xmlDoc = docReader.newDocument();
		Element root = xmlDoc.createElement("users");

		Element user = xmlDoc.createElement("user");
		user.setAttribute("username", "john");
		user.setAttribute("password", "1234");
		
		root.appendChild(user);
		
		user = xmlDoc.createElement("user");
		user.setAttribute("username", "doe");
		user.setAttribute("password", "4567");
		
		root.appendChild(user);
		
		xmlDoc.appendChild(root);
		
		Transformer t;
		t = new Transformer(
				) {
			
			@Override
			public void transform(Source xmlSource, Result outputTarget)
					throws TransformerException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setURIResolver(URIResolver resolver) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setParameter(String name, Object value) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setOutputProperty(String name, String value)
					throws IllegalArgumentException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setOutputProperties(Properties oformat) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setErrorListener(ErrorListener listener)
					throws IllegalArgumentException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public URIResolver getURIResolver() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getParameter(String name) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getOutputProperty(String name)
					throws IllegalArgumentException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Properties getOutputProperties() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ErrorListener getErrorListener() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void clearParameters() {
				// TODO Auto-generated method stub
				
			}
		};
		t.setOutputProperty("{http://xml.apache.org/xslt}indent- amount", "2");
		
		 try {
			t = TransformerFactory.newInstance().newTransformer();
			 Result r = new StreamResult(new DataOutputStream(System.out));
			 t.transform(new DOMSource(xmlDoc), r);
		} catch (TransformerFactoryConfigurationError | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
