using System;
using System.Collections.Generic;
using System.Linq;

namespace _09.OddFilter
{
    public class Program
    {
        public static void Main()
        {
            var input = Console.ReadLine()
                .Trim()
                .Split()
                .Select(int.Parse)
                .ToList();
            input.RemoveAll(n => n % 2 != 0);
            var sum = input.Sum() / input.Count;
            
            for (int i = 0; i < input.Count; i++)
            {
                int current = input[i];
                if (current <= sum)
                {
                    current--;
                    input[i] = current;
                }
                else
                {
                    current++;
                    input[i] = current;
                }
            }
            var result = string.Join(" ", input);
            Console.WriteLine(result);
        }
    }
}
