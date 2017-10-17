package osm;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by bsmoehring on 17/10/17.
 */

public class WalkableHandler extends DefaultHandler{
	
	boolean node = false;
	int countNodes = 0;
	int countLinks = 0;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if (qName.equalsIgnoreCase("node")) {
			this.countNodes++;
			double x = Double.parseDouble(attributes.getValue("lat"));
			double y = Double.parseDouble(attributes.getValue("lon"));
//			int id = Integer.parseInt(attributes.getValue("id"));
//			Importer.network.createNode(x, y,  id);
			System.out.println(countNodes + " " + qName + " " + attributes.getValue("lat") + " " + attributes.getValue("lon"));
		}
		
		if (qName.equalsIgnoreCase("way")) {
			this.countLinks++;
			int id = Integer.parseInt(attributes.getValue("id"));
//			int nodeFrom = Integer.parseInt(attributes.getValue("ref"));
//			int nodeTo = Integer.parseInt(attributes.getValue("ref"));
			System.out.println(countLinks + " " + qName + " " 
//					+ nodeFrom + " " + nodeTo
					);
//			Importer.network.createLink(Importer.network.getNodes().get, to, id, room)
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("student")) {
			System.out.println("End Element :" + qName);
		}
	}

}
