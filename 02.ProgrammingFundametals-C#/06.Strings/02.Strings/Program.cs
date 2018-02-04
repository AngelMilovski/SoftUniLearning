
namespace _02.Strings
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Text;
    using System.Numerics;
    using System.Threading.Tasks;

    public class Program
    {
        public static void Main()
        {
            var input = Console.ReadLine()
                .Trim()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(BigInteger.Parse)
                .ToArray();
            var n = (int)(input[0]);
            var number = input[1];
            BigInteger remeinder = 0;
            var result = "";

            if (n >= 2 && n <= 10)
            {
                while (number != 0)
                {
                    remeinder = number % n;
                    number /= n;
                    result = remeinder.ToString() + result;
                }
                Console.WriteLine(result);
            }
            else
            {
                Console.WriteLine(0);
            }
        }
    }
}
