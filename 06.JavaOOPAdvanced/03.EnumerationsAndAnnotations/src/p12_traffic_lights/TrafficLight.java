package p12_traffic_lights;

public class TrafficLight {

    private Signal signal;

    TrafficLight(String signal) {
        this.signal = Signal.valueOf(signal);
    }

     void changeSignal() {
        this.signal = Signal.values()[(this.signal.ordinal() + 1) % 3];
    }

    @Override
    public String toString() {
        return this.signal.name();
    }
}
