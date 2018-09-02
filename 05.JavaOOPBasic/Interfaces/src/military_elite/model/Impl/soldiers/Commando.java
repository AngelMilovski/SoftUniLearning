package military_elite.model.Impl.soldiers;

import military_elite.model.api.ICommando;
import military_elite.model.api.IMission;

import java.util.LinkedHashSet;
import java.util.Set;

public class Commando extends SpecialistSoldier implements ICommando {
    private Set<IMission> missions;

    public Commando(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new LinkedHashSet<>();
    }

    @Override
    public Iterable<IMission> getMissions() {
        return this.missions;
    }

    @Override
    public void addMission(IMission mission) {
        this.missions.add(mission);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator()).append("Missions:");
        for (IMission mission : this.missions) {
            sb.append(System.lineSeparator()).append("  ").append(mission);
        }
        return sb.toString();
    }
}