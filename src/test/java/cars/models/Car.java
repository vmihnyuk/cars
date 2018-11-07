package cars.models;

public class Car {
    String make;
    String model;
    int year;
    String name;
    String availableEngines;
    String transmissions;

    public void setMake(String make){
        this.make = make;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAvailableEngines(String engines){
        this.availableEngines = engines;
    }

    public void setTransmissions(String transmissions){
        this.transmissions = transmissions;
    }

    public String getMake(){
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear(){
        return this.year;
    }

    public String getName(){
        return this.name;
    }

    public String getAvailableEngines(){
        return this.availableEngines;
    }

    public String getTransmissions(){
        return this.transmissions;
    }
}
