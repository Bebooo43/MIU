package assignments.lab4_factory;

public class AccountDAOEnvironment implements Environment {

    @Override
    public GenericAccountDAO createDAO(EnvironmentType type) {
        if(type.equals(EnvironmentType.PROD))
            return new AccountDAOImpl();
        else if(type.equals(EnvironmentType.TEST))
            return new MockAccountDAOImpl();
        else
            throw new IllegalArgumentException("Invalid EnvironmentType");
    }
}
