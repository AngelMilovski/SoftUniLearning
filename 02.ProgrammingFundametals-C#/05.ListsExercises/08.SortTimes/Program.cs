using System;
using System.Collections.Generic;
using System.Linq;

namespace _08.SortTimes
{
    public class Program
    {
        public static void Main()
        {
            var inputTimes = Console.ReadLine()
                .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .ToList();
            inputTimes.Sort();
            string result = string.Join(", ", inputTimes);
            Console.WriteLine(result);
        } 
    }
}
