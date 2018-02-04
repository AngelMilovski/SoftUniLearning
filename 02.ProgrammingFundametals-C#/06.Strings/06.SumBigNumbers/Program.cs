using System;
using System.Linq;
using System.Text;

namespace _06.SumBigNumbers
{
    public class Program
    {
        public static void Main()
        {
            var firstNumber = Console.ReadLine().TrimStart('0');
            var secondNumber = Console.ReadLine().TrimStart('0');
            if (firstNumber.Length > secondNumber.Length)
            {
                secondNumber = secondNumber.PadLeft(firstNumber.Length, '0');
            }
            else if (firstNumber.Length <= secondNumber.Length)
            {
                firstNumber = firstNumber.PadLeft(secondNumber.Length, '0');
            }
            var isOverNine = false;
            var result = string.Empty;
            for (int i = 0; i < firstNumber.Length; i++)
            {
                var addend = Convert.ToInt32(firstNumber.Substring(firstNumber.Length - 1 - i, 1));
                var addedUp = Convert.ToInt32(secondNumber.Substring(secondNumber.Length - 1 - i, 1));
                var sum = addend + addedUp;
                sum += (isOverNine ? 1 : 0);
                isOverNine = false;
                if (sum > 9 && i != firstNumber.Length - 1)
                {
                    isOverNine = true;
                    sum -= 10;
                }
                result = sum.ToString() + result;
            }
            Console.WriteLine(result);
        }
    }
}
