package assignments.lab7_state;

public class MediumSpeedState implements State{

    private CeilingFan ceilingFan;

    public MediumSpeedState(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void pullGreen() {
        ceilingFan.setState(ceilingFan.getHighState());
        System.out.println( "high speed" );
    }

    @Override
    public void pullRed() {
        ceilingFan.setState(ceilingFan.getLowState());
        System.out.println( "low speed" );
    }
}
