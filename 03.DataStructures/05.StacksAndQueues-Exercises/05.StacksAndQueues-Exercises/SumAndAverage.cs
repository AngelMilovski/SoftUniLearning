using System;
using System.Collections.Generic;

public class SumAndAverage
{
    public static void Main()
    {
        string[] input = Console.ReadLine()
            .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
        if (input.Length == 0)
        {
            Console.WriteLine($"Sum=0; Average=0.0");
            return;
        }
        List<int> nums = new List<int>();
        double sum = 0.0D;

        for (int i = 0; i < input.Length; i++)
        {
            nums.Add(int.Parse(input[i]));
            sum += nums[i];
        }
        double average = sum / nums.Count;

        Console.WriteLine($"Sum={sum:F0}; Average={average:F2}");
    }
}