package lld.nullobjectpattern;

/**
 * @author Anirudh
 * @since 03/11/25
 */
public class NullObject implements Vehicle {
    @Override
    public int getTankCapacity() {
        return 0;
    }

    @Override
    public int getSeatCapacity() {
        return 0;
    }
}
