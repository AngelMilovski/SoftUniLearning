using System;
using System.Collections.Generic;

public class CitiesByContinentAndCountry
{
    public static void Main()
    {
        var continentsData = new Dictionary<string, Dictionary<string, List<string>>>();
        int n = int.Parse(Console.ReadLine());

        for (int i = 0; i < n; i++)
        {
            var input = Console.ReadLine()
                .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
            var continent = input[0];
            var country = input[1];
            var city = input[2];

            if (!continentsData.ContainsKey(continent))
            {
                continentsData[continent] = new Dictionary<string, List<string>>();
            }
            if (!continentsData[continent].ContainsKey(country))
            {
                continentsData[continent][country] = new List<string>();
            }
            continentsData[continent][country].Add(city);
        }

        foreach (var continentCountries in continentsData)
        {
            var continentsName = continentCountries.Key;
            var countries = continentCountries.Value;
            Console.WriteLine($"{continentsName}:");
            foreach (var countriesData in countries)
            {
                var countryName = countriesData.Key;
                var citiesName = countriesData.Value;
                var cities = string.Join(", ", citiesName);
                Console.WriteLine($"  {countryName} -> {cities}");
            }
        }
    }
}