package mars_rover;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RoverEqualityTests {
    @Test
    public void equalRovers() {
        assertEquals(new Rover(1, 1, "N"), new Rover(1, 1, "N"));
    }

    @Test
    public void notEqualRovers() {
        assertFalse(new Rover(1, 1, "N").equals(new Rover(1, 1, "S")));
        assertFalse(new Rover(1, 1, "N").equals(new Rover(1, 2, "N")));
        assertFalse(new Rover(1, 1, "N").equals(new Rover(0, 1, "N")));
    }
}
