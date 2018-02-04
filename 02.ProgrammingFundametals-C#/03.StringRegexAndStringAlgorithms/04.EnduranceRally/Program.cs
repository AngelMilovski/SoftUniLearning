using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        string[] drivers = Split(Console.ReadLine());
        double[] track = Split(Console.ReadLine())
            .Select(double.Parse)
            .ToArray();
        int[] checkpoints = Split(Console.ReadLine())
            .Select(int.Parse)
            .Where(c => c >= 0 && c < track.Length)
            .ToArray();

        foreach (var driver in drivers)
        {
            double fuel = (driver.First());

            for (int i = 0; i < track.Length; i++)
            {
                var currentZoneFuel = track[i];

                if (checkpoints.Contains(i))
                {
                    fuel += currentZoneFuel;
                }
                else
                {
                    fuel -= currentZoneFuel;
                }
                if (fuel <= 0)
                {
                    Console.WriteLine($"{driver} - reached {i}");
                    continue;
                }
            }
            if (fuel > 0)
            {
                Console.WriteLine($"{driver} - fuel left {fuel:F2}");
            }
        }

    }

    private static string[] Split(string input)
    {
        return input
            .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
    }
}