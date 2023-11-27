package acki.workshop1;

public class WindowActuator extends Actuator {
    public WindowActuator(Boolean isOpen) {
        super(isOpen);
    }

    @Override
    public String toString() {
        return "WindowActuator (" + (isOpen ? "open" : " closed") + ")";
    }
}