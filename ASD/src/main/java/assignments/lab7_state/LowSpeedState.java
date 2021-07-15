package assignments.lab7_state;

public class LowSpeedState implements State{

    private CeilingFan ceilingFan;

    public LowSpeedState(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void pullGreen() {
        ceilingFan.setState(ceilingFan.getMediumState());
        System.out.println( "medium speed" );
    }

    @Override
    public void pullRed() {
        ceilingFan.setState(ceilingFan.getOffState());
        System.out.println( "turning off" );
    }
}
