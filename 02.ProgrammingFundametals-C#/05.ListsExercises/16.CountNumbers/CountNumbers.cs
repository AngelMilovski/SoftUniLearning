namespace _16.CountNumbers
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    class CountNumbers
    {
        public static void Main()
        {
            var input = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToList();
            var sortedNums = new SortedDictionary<int, int>();
            foreach (var num in input)
            {
                if (!sortedNums.ContainsKey(num))
                {
                    sortedNums[num] = 0;
                }
                sortedNums[num]++;
            }
            foreach (var num in sortedNums)
            {
                Console.WriteLine($"{num.Key} -> {num.Value}");
            }
        }
    }
}
