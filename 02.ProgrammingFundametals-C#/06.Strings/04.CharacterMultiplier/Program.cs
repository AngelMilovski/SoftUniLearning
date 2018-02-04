

namespace _04.CharacterMultiplier
{
    using System;
    using System.Numerics;
   
    public class Program
    {
        public static void Main()
        {
            var input = Console.ReadLine()
                .Trim()
                .Split(new char[] { ' ' },StringSplitOptions.RemoveEmptyEntries);

            string firstLetters = input[0];
            string secondLetters = input[1];
            var compared = firstLetters.Length.CompareTo(secondLetters.Length);
            var minString = Math.Min(firstLetters.Length, secondLetters.Length);
            var multiplyChars = new BigInteger();
            var sum = new BigInteger();
            for (int i = 0; i < minString; i++)
            {
                var current = firstLetters[i];
                var next = secondLetters[i];
                multiplyChars = current * next;
                sum += multiplyChars;
            }
            if (compared == 1)
            {
                for (int i = secondLetters.Length; i < firstLetters.Length; i++)
                {
                    sum += firstLetters[i];
                }
            }
            else if (compared == -1)
            {
                for (int i = firstLetters.Length; i < secondLetters.Length; i++)
                {
                    sum += secondLetters[i];
                }
            }
            Console.WriteLine(sum);
        }  
    }
}
