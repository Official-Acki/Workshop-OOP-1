package acki.workshop1;

public class VentilationActuator extends Actuator {
    public VentilationActuator(Boolean isOpen) {
        super(isOpen);
    }

    @Override
    public String toString() {
        return "VentilationActuator (" + (isOpen ? "open" : " closed") + ")";
    }
}