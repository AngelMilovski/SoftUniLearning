package p11_threeuple;

public class Tuple<F, L>  {

    private F firstName;
    private L lastName;

    public Tuple(F firsName, L lastName) {
       this.firstName = firsName;
       this.lastName = lastName;
    }

    public F getFirstName() {
        return this.firstName;
    }

    public L getLastName() {
        return this.lastName;
    }
}