package assignments.lab4_factory;

public interface Environment {


    GenericAccountDAO createDAO(EnvironmentType type);

}
