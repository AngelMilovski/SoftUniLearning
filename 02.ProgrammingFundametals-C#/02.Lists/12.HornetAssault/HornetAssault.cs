using System;
using System.Collections.Generic;
using System.Linq;

public class HornetAssault
{
    public static void Main()
    {
        List<long> beehives = Console.ReadLine()
            .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
            .Select(long.Parse)
            .ToList();
        List<long> hornets = Console.ReadLine()
            .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
            .Select(long.Parse)
            .ToList();
        long hornetsPower = hornets.Sum();

        for (int i = 0; i < beehives.Count; i++)
        {
            long beehive = beehives[i];
            if (hornets.Count == 0)
            {
                break;
            }
            if (beehive < hornetsPower)
            {
                beehives[i] = 0;
            }
            else
            {
                beehives[i] -= hornetsPower;
                hornetsPower -= hornets[0];
                hornets.RemoveAt(0);
            }
        }

        if (beehives.Sum() > 0)
        {
            Console.WriteLine(string.Join(" ", beehives.Where(n => n != 0)));
        }
        else
        {
            Console.WriteLine(string.Join(" ", hornets));
        }
    }
}