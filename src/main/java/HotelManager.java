import java.util.ArrayList;
import java.util.List;

public class HotelManager {
    public static void main(String[] args) {
        Logger.getInstance().log("Managing hotel...");

        // create hotel rooms
        HotelRoom anugsRoom = new HotelRoom();
        HotelRoom drakesRoom = new HotelRoom();
        HotelRoom joshsRoom = new HotelRoom();

        anugsRoom.book("Anug");
        drakesRoom.book("Drake");
        joshsRoom.book("Josh");

        // create hotel floors
        HotelFloor firstFloor = new HotelFloor();
        HotelFloor secondFloor = new HotelFloor();

        // add hotel rooms to hotel floors
        firstFloor.addHotelRoom(anugsRoom);
        secondFloor.addHotelRoom(drakesRoom);
        secondFloor.addHotelRoom(joshsRoom);

        // take actions on rooms and floors and examine your output to ensure you implemented the desired
        // behaviors
        firstFloor.clean();
        secondFloor.clean();


    }
}

interface HotelRoomInterface {
    void book(String guestName);

    void clean();
}

class HotelRoom implements HotelRoomInterface {
    public void book(String guestName) {
        Logger.getInstance().log("Booked a room for " + guestName);
    }

    public void clean() {
        Logger.getInstance().log("Cleaned room");
    }
}

class HotelFloor implements HotelRoomInterface {
    private List<HotelRoomInterface> hotelRooms = new ArrayList<HotelRoomInterface>();

    public void book(String guestName) {
        hotelRooms.forEach(child -> {
            child.book(guestName);
        });
    }

    public void clean() {
        hotelRooms.forEach(child -> child.clean());
    }

    public void addHotelRoom(HotelRoomInterface hotelRoom) {
        hotelRooms.add(hotelRoom);
    }

    public void removeHotelRoom(HotelRoomInterface hotelRoom) {
        hotelRooms.remove(hotelRoom);
    }
}

