using System;
using System.Collections.Generic;

public class MinerTask
{
    public static void Main()
    {
        var allResource = new Dictionary<string, long>();
        var resource = Console.ReadLine().Trim();
        
        while (resource != "stop".Trim())
        {
            var quantity = long.Parse(Console.ReadLine());
            if (!allResource.ContainsKey(resource))
            {
                allResource[resource] = 0;
            }
            allResource[resource] += quantity;

            resource = Console.ReadLine();
        }
        foreach (var kvp in allResource)
        {
            Console.WriteLine($"{kvp.Key} -> {kvp.Value}");
        }
    }
}