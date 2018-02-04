namespace _15.SquareNumbers
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    class SquareNumbers
    {
        public static void Main()
        {
            var nums = Console.ReadLine()
                .Split(' ')
                .Select(double.Parse)
                .ToArray();
            var listFromSquareNums = new List<double>();

            foreach (var num in nums)
            {
                if (Math.Sqrt(num) == (int)(Math.Sqrt(num)))
                {
                    listFromSquareNums.Add(num);
                }
            }
            listFromSquareNums.Sort((a, b) => b.CompareTo(a));
            Console.WriteLine(string.Join(" ", listFromSquareNums));
        }
    }
}
