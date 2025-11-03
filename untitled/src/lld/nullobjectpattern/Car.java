package lld.nullobjectpattern;

/**
 * @author Anirudh
 * @since 03/11/25
 */
public class Car implements Vehicle {
    @Override
    public int getTankCapacity() {
        return 40;
    }

    @Override
    public int getSeatCapacity() {
        return 5;
    }
}
