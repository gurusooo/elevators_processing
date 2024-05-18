import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Elevator {
    private int id;
    private int curFloor;
    private List<Integer> targetFloors;
    private String direction;

    public Elevator (int id) {
        this.id = id;
        this.curFloor = 1;
        this.targetFloors = new CopyOnWriteArrayList<>();
        this.direction = null;
    }

    public int getId() {
        return id;
    }

    public int getCurFloor() {
        return curFloor;
    }

    public List <Integer> getTargetFloors() {
        return targetFloors;
    }

    public void moves() {
        if (!targetFloors.isEmpty()) {
            int nextFloor = targetFloors.get(0);
            if (curFloor < nextFloor) {
                curFloor++;
                direction = "up";
            } else if (curFloor > nextFloor) {
                curFloor--;
                direction = "down";
            }
            if (curFloor == nextFloor) {
                targetFloors.remove(0);
                if (targetFloors.isEmpty()) {
                    direction = null;
                }
            }
        }
    }

    public void addTargetFloor(int floor) {
        if (!targetFloors.contains(floor)) {
            targetFloors.add(floor);
            targetFloors.sort(Integer::compareTo);
        }
    }

    public String getDirection() {
        return direction;
    }
}
