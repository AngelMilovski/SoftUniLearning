package military_elite.model.api;

public interface ILeutenantGeneral extends IPrivate {
    Iterable<Soldier> getPrivates();

    void addPrivate(Soldier priv);
}