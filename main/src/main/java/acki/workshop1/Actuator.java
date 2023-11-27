package acki.workshop1;

public abstract class Actuator {
   
    boolean isOpen;

    public Actuator(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public void setOpen(boolean state){
        this.isOpen = state;
    }

    public boolean getOpen(){
        return this.isOpen;
    }
}
