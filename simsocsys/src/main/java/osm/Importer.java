package osm;

import java.io.File;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import simulation.Network;

public class Importer {
	
	public static Network network;

	public static void main(String[] args) {

		network = new Network();
		
		try {
			
			File inputFile = new File("D:/Wichtiges/TUBerlin/Masterarbeit/Data/Alexanderplatz/Alexanderplatz_FootwayAndSteps.osm");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			WalkableHandler walkableHandler = new WalkableHandler();
			saxParser.parse(inputFile, walkableHandler); 
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
		
	}

}
