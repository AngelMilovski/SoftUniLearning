import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class p10_PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        Map<String, List<Cities>> countries = new LinkedHashMap<>();
        String line;
        while (true) {
            if ("report".equals(line = reader.readLine())) {
                break;
            }
            String[] tokens = line.split("\\|");
            String country = tokens[1];
            String cityName = tokens[0];
            long population = Long.parseLong(tokens[2]);

            if (!countries.containsKey(country)) {
                countries.put(country, new ArrayList<>());
            }
            List<Cities> test = new ArrayList<>();
            Cities dataCity = new Cities();
            dataCity.setCityName(cityName);
            dataCity.setPopulation(population);
            dataCity.totalPopulation();
            test.add(dataCity);
            countries.put(country, test);

        }
    }
}

class Cities {
    public String cityName = "";
    public long population;
    public long totalPopulation;
    private long sum = 0;

    Cities() {
        this.cityName = cityName;
        this.population = population;
    }

    public String getCityName(String city) {
        return this.cityName;
    }

    public void setCityName(String city) {
        this.cityName = city;
    }

    public long getPopulation(long population) {
        return this.population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    private void setTotalPopulation() {
        this.totalPopulation = this.population;
    }

    public long totalPopulation() {
        return this.totalPopulation += this.population;
    }


}