import java.util.ArrayList;
import java.util.List;

public class Elev_work {
    private List<Elevator> elevators;

    public Elev_work(int numElevs) {
        elevators = new ArrayList<>();
        for (int i = 1; i <= numElevs; i++) {
            elevators.add(new Elevator(i));
        }
    }

    public synchronized void reqElevator(int reqFloor) {
        Elevator bestElevator = null;
        int minDist = Integer.MAX_VALUE;
        for (Elevator elevator : elevators) {
            int distance = Math.abs(elevator.getCurFloor() - reqFloor);
            if ((elevator.getDirection() == null) ||
                    (elevator.getDirection().equals("up") && elevator.getCurFloor() <= reqFloor) ||
                    (elevator.getDirection().equals("down") && elevator.getCurFloor() >= reqFloor)) {
                if (distance < minDist) {
                    bestElevator = elevator;
                    minDist = distance;
                }
            }
        }
        if (bestElevator != null) {
            bestElevator.addTargetFloor(reqFloor);
        }
    }

    public void step() {
        for (Elevator elevator : elevators) {
            elevator.moves();
        }
    }

    public void printCondition() {
        for (Elevator elevator : elevators) {
            System.out.println("Elevator " + elevator.getId() + ": Floor " + elevator.getCurFloor() + ", Target floors: " + elevator.getTargetFloors());
        }
    }
}
