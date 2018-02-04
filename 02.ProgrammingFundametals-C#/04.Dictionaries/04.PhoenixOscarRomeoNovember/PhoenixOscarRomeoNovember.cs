using System;
using System.Collections.Generic;
using System.Linq;

public class PhoenixOscarRomeoNovember
{
    public static void Main()
    {
        
        var creatures = new Dictionary<string, HashSet<string>>();
        var check = new List<string>();
        var input = Console.ReadLine();

        while (input != "Blaze it!")
        {
            var data = input
                .Split("-> ".ToCharArray(), StringSplitOptions.RemoveEmptyEntries);

            var creature = data[0];
            var squadMate = data[1];
            check.Add(squadMate + "" + creature);

            if (!creatures.ContainsKey(creature))
            {
                creatures[creature] = new HashSet<string>();
            }
            
            if (creature == squadMate || check.Contains(creature + "" + squadMate))
            {
                creatures[squadMate].Remove(creature);
                input = Console.ReadLine();
                continue;
            }
            creatures[creature].Add(squadMate);

            input = Console.ReadLine();
        }
        foreach (var item in creatures
            .OrderByDescending(x => x.Value.Count))
        {
            Console.WriteLine($"{item.Key} : {item.Value.Count}");
        }
    }
}