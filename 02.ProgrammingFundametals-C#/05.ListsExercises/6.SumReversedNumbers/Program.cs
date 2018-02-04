using System;
using System.Collections.Generic;


namespace _6.SumReversedNumbers
{
    public class Program
    {
        public static void Main()
        {
            var input = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
            int sum = 0;
            for (int i = 0; i < input.Length; i++)
            {
                var number = input[i].ToCharArray();
                var test = new List<char>();
                for (int j = 0; j < number.Length; j++)
                {
                    char curentNum = number[number.Length - 1 - j];
                    test.Add(curentNum);
                }
                sum += int.Parse(string.Join("", test));
            }
            Console.WriteLine(sum);
        }
    }
}
