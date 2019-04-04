using System;
using System.Collections.Generic;
using System.Linq;

public class CountOfOccurrences
{
    public static void Main()
    {
        var numbers = new SortedDictionary<int, int>();
        var input = Console.ReadLine()
            .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
            .Select(int.Parse)
            .ToArray();

        foreach (var num in input)
        {
            if (!numbers.ContainsKey(num))
            {
                numbers[num] = 0;
            }
            numbers[num]++;
        }
        
        foreach (var kvp in numbers)
        {
            Console.WriteLine($"{kvp.Key} -> {kvp.Value} times");
        }
    }
}