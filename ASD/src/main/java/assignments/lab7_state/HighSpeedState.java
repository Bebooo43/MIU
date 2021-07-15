package assignments.lab7_state;

public class HighSpeedState implements State{

    private CeilingFan ceilingFan;

    public HighSpeedState(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void pullGreen() {
        ceilingFan.setState(ceilingFan.getOffState());
        System.out.println( "turning off" );
    }

    @Override
    public void pullRed() {
        ceilingFan.setState(ceilingFan.getMediumState());
        System.out.println( "medium speed" );
    }
}
