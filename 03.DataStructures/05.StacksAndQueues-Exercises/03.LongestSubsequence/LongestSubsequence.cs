using System;
using System.Linq;

public class LongestSubsequence
{
    public static void Main()
    {
        int[] input = Console.ReadLine()
            .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
            .Select(int.Parse)
            .ToArray();

        int count = 1;
        int longestCount = 1;
        int printNum = 0;
        
        for (int i = 1; i < input.Length; i++)
        {
            int current = input[i];
            int prev = input[i - 1];
            if (current == prev)
            {
                count++;
            }
            else
            {
                count = 1;
            }
            if (count > longestCount)
            {
                longestCount = count;
                printNum = current;
            }
        }
        for (int i = 0; i < longestCount; i++)
        {
            Console.Write(printNum + " ");
        }
        Console.WriteLine();
    }
}