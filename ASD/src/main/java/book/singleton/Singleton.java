package book.singleton;

public class Singleton {
    //volatile keyword ensures that multiple threads handle the uniqueInstance variable correctly when it is being initialized to the Singleton instance.
    private volatile static Singleton INSTANCE;
    private Singleton(){ }

    public Singleton getInstance(){
        if(INSTANCE==null){
            //synchronize only the first time through! (cause is slow)
            synchronized (Singleton.class){
                if(INSTANCE==null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}
