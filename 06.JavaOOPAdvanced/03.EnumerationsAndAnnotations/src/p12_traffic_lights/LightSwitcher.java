package p12_traffic_lights;

import java.util.ArrayList;
import java.util.List;

class LightSwitcher {

    private List<TrafficLight> switcher;

    LightSwitcher() {
        this.switcher = new ArrayList<>();
    }

    List<TrafficLight> getSwitcher() {
        return this.switcher;
    }

    void addTrafficLight(TrafficLight trafficLight) {
        this.switcher.add(trafficLight);
    }

    void switchSignal() {
        for (TrafficLight trafficLight : this.switcher) {
            trafficLight.changeSignal();
        }
    }
}
