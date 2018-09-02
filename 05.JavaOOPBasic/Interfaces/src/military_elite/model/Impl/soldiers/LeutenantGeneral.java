package military_elite.model.Impl.soldiers;

import military_elite.model.api.ILeutenantGeneral;
import military_elite.model.api.Soldier;

import java.util.Set;
import java.util.TreeSet;

public class LeutenantGeneral extends Private implements ILeutenantGeneral {
    private Set<Soldier> privates;

    public LeutenantGeneral(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new TreeSet<>();
    }

    @Override
    public Iterable<Soldier> getPrivates() {
        return this.privates;
    }

    @Override
    public void addPrivate(Soldier priv) {
        this.privates.add(priv);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator()).append("Privates:");
        this.privates.forEach(p -> sb.append(System.lineSeparator()).append("  ").append(p));
        return sb.toString();
    }
}