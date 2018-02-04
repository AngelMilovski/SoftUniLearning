using System;

namespace _07.MultiplyBignumberForSum
{
    public class Program
    {
        public static void Main()
        {
            var firstNumber = Console.ReadLine().TrimStart('0');
            var secondNumber = int.Parse(Console.ReadLine());
            var numberForSum = 0;
            var remainder = 0;
            var result = "";
            if (firstNumber == "0" || secondNumber == 0 || firstNumber == "") 
            {
                Console.WriteLine(0);
                return;
            }
            for (int i = firstNumber.Length - 1; i >= 0; i--)
            {
                var multiplier = Convert.ToInt32(firstNumber.Substring(i, 1));
                var multiplier2 = secondNumber;
                var sum = 0;
                if (i == 0)
                {
                    sum = multiplier * multiplier2 + remainder;
                }
                else
                {
                    sum = multiplier * multiplier2 + remainder;
                    numberForSum = sum % 10;
                    remainder = sum / 10;
                    sum = numberForSum;
                }
                    result = sum.ToString() + result;
            }
            Console.WriteLine(result);
        }
    }
}
