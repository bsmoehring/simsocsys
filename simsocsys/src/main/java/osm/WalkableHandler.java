package osm;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WalkableHandler extends DefaultHandler{
	
	boolean node = false;
	int countNodes = 0;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if (qName.equalsIgnoreCase("node")) {
			this.countNodes++;
//			int x = attributes.getValue("lat").;
//			Importer.network.createNode(attributes.getValue("lat"), attributes.getValue("lon"),  id)
			System.out.println(countNodes + " " + qName + " " + attributes.getValue("lat") + " " + attributes.getValue("lon"));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("student")) {
			System.out.println("End Element :" + qName);
		}
	}

}
