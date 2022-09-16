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
        assertNotEquals(new Rover(1, 1, "N"), new Rover(1, 1, "S"));
        assertNotEquals(new Rover(1, 1, "N"), new Rover(1, 2, "N"));
        assertNotEquals(new Rover(1, 1, "N"), new Rover(0, 1, "N"));
    }
}
