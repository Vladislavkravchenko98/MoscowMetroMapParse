package root;

import java.util.ArrayList;

public class Station {
    private String name;
    private String numberOfLine;


    public Station(String name, String numberofline) {
        this.name = name;
        this.numberOfLine = numberofline;

    }
    public Station() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberOfLine() {
        return numberOfLine;
    }

    public void setNumberofline(String numberofline) {
        this.numberOfLine = numberofline;
    }



    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                ", numberofline='" + numberOfLine + '\'' +
                '}';
    }
}
