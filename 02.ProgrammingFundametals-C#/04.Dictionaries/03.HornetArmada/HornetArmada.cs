using System;
using System.Collections.Generic;
using System.Linq;

public class HornetArmada
{
    public static void Main()
    {
        var legionAndActivity = new Dictionary<string, long>();
        var legionSoldierTypeAndCount = new Dictionary<string, Dictionary<string, long>>();
        int n = int.Parse(Console.ReadLine());

        for (int i = 0; i < n; i++)
        {
            var input = Console.ReadLine()
                .Split("=->: ".ToCharArray(), StringSplitOptions.RemoveEmptyEntries);
            var activity = long.Parse(input[0]);
            var legion = input[1];
            var soldierType = input[2];
            var soldierCount = long.Parse(input[3]);

            if (!legionSoldierTypeAndCount.ContainsKey(legion))
            {
                legionAndActivity[legion] = activity;
                legionSoldierTypeAndCount[legion] = new Dictionary<string, long>();
            }
            if (!legionSoldierTypeAndCount[legion].ContainsKey(soldierType))
            {
                legionSoldierTypeAndCount[legion][soldierType] = soldierCount;
            }
            else
            {
                legionSoldierTypeAndCount[legion][soldierType] += soldierCount;
            }
            if (legionAndActivity[legion] < activity)
            {
                legionAndActivity[legion] = activity;
            }
        }
        var command = Console.ReadLine();
        if (command.IndexOf('\\') != -1)
        {
            var activity = long.Parse(command.Substring(0, command.IndexOf('\\')));
            var soldier = command.Substring(command.IndexOf('\\') + 1);

            foreach (var item in legionSoldierTypeAndCount
                .Where(e => legionSoldierTypeAndCount[e.Key].ContainsKey(soldier))
                .OrderByDescending(k => k.Value[soldier]))
            {
                if (legionAndActivity[item.Key] < activity)
                {
                    Console.WriteLine($"{item.Key} -> {item.Value[soldier]}");
                }

            }
        }
        else
        {
            
            foreach (var item in legionAndActivity
                .OrderByDescending(k => k.Value))
            {
                if (legionSoldierTypeAndCount[item.Key].ContainsKey(command))
                {
                    Console.WriteLine($"{item.Key} : {item.Value}");
                }
               
            }
        }
    }
}