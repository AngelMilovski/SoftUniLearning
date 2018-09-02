package military_elite.model.api;

public interface ICommando {
    Iterable<IMission> getMissions();

    void addMission(IMission mission);
}