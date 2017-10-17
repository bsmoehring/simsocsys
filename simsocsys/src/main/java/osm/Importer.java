package osm;

import java.io.File;

/**
 * Created by bsmoehring on 17/10/17.
 */

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import simulation.Network;
import simulation.Vis;
import simulation.Walls;

public class Importer {
	
	public static Network network;
	public static Walls walls;

	public static void main(String[] args) {

		network = new Network();
		walls = new Walls();
		
		try {
			
			File inputFile = new File("D:/Wichtiges/TUBerlin/Masterarbeit/Data/Alexanderplatz/Alexanderplatz_FootwayAndSteps.osm");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			WalkableHandler walkableHandler = new WalkableHandler();
			saxParser.parse(inputFile, walkableHandler); 
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
		
//		Vis vis = new Vis(network, walls);
		
		
		
	}

}
