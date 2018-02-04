using System;
using System.Linq;
using System.Collections.Generic;

namespace _4.LongestIncreasingSubsequence
{
    public class Program
    {
        public static void Main()
        {
            var inputNumbers = Console.ReadLine()
                .Trim()
                .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();

            int[] len = new int[inputNumbers.Length];
            int[] prev = new int[inputNumbers.Length];
            int longestCount = 1;
            int maxCount = 1;

            for (int i = 0; i < inputNumbers.Length; i++)
            {
                int current = inputNumbers[i];
                for (int j = 1; j < inputNumbers.Length; j++)
                {

                }
                
            }
        }
    }
}
