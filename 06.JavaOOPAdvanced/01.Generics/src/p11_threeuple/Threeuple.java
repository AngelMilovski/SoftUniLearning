package p11_threeuple;

public class Threeuple<F, S, T> {


    private F firstItem;
    private S secondItem;
    private T thirdItem;

    public Threeuple(F firstItem, S secondItem, T thirdItem) {
        this.firstItem = firstItem;
        this.secondItem = secondItem;
        this.thirdItem = thirdItem;
    }

    public F getFirstItem() {
        return this.firstItem;
    }

    public S getSecondItem() {
        return this.secondItem;
    }

    public T getThirdItem() {
        return this.thirdItem;
    }
}
