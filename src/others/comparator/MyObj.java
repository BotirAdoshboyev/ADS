package others.comparator;

public class MyObj {
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyObj() {
    }

    public MyObj(Integer number, String name) {
        this.number = number;
        this.name = name;
    }

    private Integer number;
    private String name;

    @Override
    public String toString() {
        return "MyObj{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
