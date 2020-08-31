package mars_rover;

public class Rover {

    private String direction;
    private int y;
    private int x;

    public Rover(int x, int y, String direction) {
        this.direction = direction;
        this.y = y;
        this.x = x;
    }

    private void rotate(String command) {
        if (direction.equals("N")) {
            direction = (command.equals("r")) ? "E" : "W";
        } else if (direction.equals("S")) {
            direction = (command.equals("r")) ? "W" : "E";
        } else if (direction.equals("W")) {
            direction = (command.equals("r")) ? "N" : "S";
        } else {
            direction = (command.equals("r")) ? "S" : "N";
        }
    }

    private void displace(String command) {
        int displacement1 = (command.equals("f")) ? 1 : -1;
        int displacement = displacement1;
        if (direction.equals("N")) {
            y += displacement;
        } else if (direction.equals("S")) {
            y -= displacement;
        } else if (direction.equals("W")) {
            x -= displacement;
        } else {
            x += displacement;
        }
    }

    public void receive(String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);
            if (command.equals("l") || command.equals("r")) {
                rotate(command);
            } else {
                displace(command);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Rover rover = (Rover) o;

        if (y != rover.y) {
            return false;
        }
        if (x != rover.x) {
            return false;
        }
        return direction != null ? direction.equals(rover.direction) : rover.direction == null;

    }

    @Override
    public int hashCode() {
        int result = direction != null ? direction.hashCode() : 0;
        result = 31 * result + y;
        result = 31 * result + x;
        return result;
    }

    @Override
    public String toString() {
        return "Rover{"
                + "direction='" + direction + '\''
                + ", y=" + y
                + ", x=" + x
                + '}';
    }
}
