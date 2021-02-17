package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PaintCalculator implements Serializable {
    private List<Room> roomList = new ArrayList<>();

    public void addRoom(double length,double width, double height){
        Room room = new Room(width, length, height);
        roomList.add(room);
    }

    @Override
    public String toString(){
        if(roomList.size() == 0){

        }
        else{
            String Areas = "";
            int counter = 0;
            for (Room room : roomList){
                counter++;
                Areas = Areas + "Room " + counter + ": " + room.getArea() +"\n";
            }
            return Areas;
        }
        return "\nNo Rooms Recorded\n";
    }

}
