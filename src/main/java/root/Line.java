package root;

import java.util.ArrayList;

public class Line {
    private String number;
    private String name;
    private ArrayList<Station> stationList;

    public Line(String number, String name, ArrayList<Station> stationlist) {
        this.number = number;
        this.name = name;
        this.stationList = stationlist;
    }
    public Line(){}

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Station> getStationList() {
        return stationList;
    }

    public void setStationlist(ArrayList<Station> stationlist) {
        this.stationList = stationlist;
    }

    @Override
    public String toString() {
        return "Line{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", stationlist=" + stationList +
                '}';
    }
}
