package arrays;

/**
 * @author Anirudh
 * @since 20/04/26
 */
public class SingleTon {


    private SingleTon() {

    }

    private static class HOLDER {
        private static final SingleTon instance = new SingleTon();
    }

    public static SingleTon getInstance() {

        return HOLDER.instance;
    }
}
