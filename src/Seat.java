public class Seat {
    private String name;

    public String getName() {
        return name;
    }

    public void reserve(String name) {
        this.name = name;
    }

    public void cancel() {
        name = null;
    }

    public boolean isOccupied() {
        return name != null;
    }

    public boolean match(String checkName) {
        if (checkName == null){
            return false;
        }
        return name.equals(checkName);
    }
}