using System;
using System.Collections.Generic;
using System.Linq;

public class RemoveOddOccurrences
{
    public static void Main()
    {
        var numbers = Console.ReadLine()
            .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
            .Select(int.Parse)
            .ToList();
        var allNumbersCount = new Dictionary<int, int>();
        for (int i = 0; i < numbers.Count; i++)
        {
            int current = numbers[i];

            if (!allNumbersCount.ContainsKey(current))
            {
                allNumbersCount[current] = 0;
            }
            allNumbersCount[current]++;
        }
        
        foreach (var num in allNumbersCount)
        {
            var number = num.Key;
            var count = num.Value;
            if (count % 2 == 1)
            {
                numbers.RemoveAll(n => n == number);
                    
            }
        }
        var output = string.Join(" ", numbers);
        Console.WriteLine(output);
    }
}