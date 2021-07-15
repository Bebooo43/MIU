package assignments.lab4_factory;

public enum EnvironmentType {
    PROD("prod"), TEST("test");

    private String value;
    EnvironmentType(String value){
        this.value = value;
    }
}
