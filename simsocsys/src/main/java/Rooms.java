import java.util.HashMap;
import java.util.Map;

public class Rooms {
	
	private Map<Integer,Room> rooms = new HashMap<Integer,Room>();
	
	public void addRoom(Room room){
		this.rooms.put(room.getId(), room);
	}
	
	public Map<Integer,Room> getRooms(){
		return this.rooms;
	}

}
