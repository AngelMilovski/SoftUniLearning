namespace _14.SortNumbers
{
    using System;
    using System.Linq;
    class SquareNumbers
    {
        public static void Main()
        {

            var inputNums = Console.ReadLine()
                .Split(' ')
                .Select(double.Parse)
                .ToList();
            inputNums.Sort();
            var result = string.Join(" <= ", inputNums);
            Console.WriteLine(result);
        }
    }
}
