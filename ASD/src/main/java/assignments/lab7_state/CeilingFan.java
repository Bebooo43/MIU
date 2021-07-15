package assignments.lab7_state;

public class CeilingFan {

    private HighSpeedState highState; //3
    private MediumSpeedState mediumState; //2
    private LowSpeedState lowState; //1
    private TurningOffState offState; //0
    private State state;

    public CeilingFan(){
        highState = new HighSpeedState(this);
        mediumState = new MediumSpeedState(this);
        lowState = new LowSpeedState(this);
        offState = new TurningOffState(this);

        state = offState;
    }

    public void pullgreen() {
        state.pullGreen();
    }

    public void pullred() {
        state.pullRed();
    }

    public HighSpeedState getHighState() { return highState; }
    public MediumSpeedState getMediumState() { return mediumState; }
    public LowSpeedState getLowState() { return lowState; }
    public TurningOffState getOffState() { return offState; }

    public void setState(State state) {
        this.state = state;
    }
}