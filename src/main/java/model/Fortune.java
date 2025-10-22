package model;

import java.io.Serializable;

public class Fortune implements Serializable {
    private String name;
    private String today;
    private String luck;

    public Fortune() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

    public String getLuck() {
        return luck;
    }

    public void setLuck(String luck) {
        this.luck = luck;
    }
}
