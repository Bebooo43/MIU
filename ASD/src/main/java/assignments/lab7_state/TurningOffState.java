package assignments.lab7_state;

public class TurningOffState implements State{

    private CeilingFan ceilingFan;

    public TurningOffState(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void pullGreen() {
        ceilingFan.setState(ceilingFan.getLowState());
        System.out.println( "low speed" );
    }

    @Override
    public void pullRed() {
        ceilingFan.setState(ceilingFan.getHighState());
        System.out.println( "high speed" );
    }
}
