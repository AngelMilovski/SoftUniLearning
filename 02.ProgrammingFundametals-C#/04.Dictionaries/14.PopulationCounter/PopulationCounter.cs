using System;
using System.Collections.Generic;
using System.Linq;

public class PopulationCounter
{
    private static string key;

    public static void Main()
    {
        var countryPopulations = new Dictionary<string, Dictionary<string, long>>();
        var input = Console.ReadLine();

        while (input != "report")
        {
            var populationData = input
                .Split(new[] { '|' }, StringSplitOptions.RemoveEmptyEntries);
            var country = populationData[1];
            var city = populationData[0];
            var population = long.Parse(populationData[2]);

            if (!countryPopulations.ContainsKey(country))
            {
                countryPopulations[country] = new Dictionary<string, long>();
            }
            if (!countryPopulations[country].ContainsKey(city))
            {
                countryPopulations[country][city] = 0;
            }
            countryPopulations[country][city] = population;
            input = Console.ReadLine();
        }

        foreach (var countries in countryPopulations
            .OrderByDescending(x => countryPopulations[x.Key]
            .Sum(e => e.Value)))
        {
            var country = countries.Key;
            var cities = countries.Value;
            var totalPopulation = cities.Sum(x => x.Value);
            Console.WriteLine($"{country} (total population: {totalPopulation})");
            foreach (var kvp in cities.OrderByDescending(v => v.Value))
            {
                Console.WriteLine($"=>{kvp.Key}: {kvp.Value}");
            }
        }
    }
}