using System;
using System.Linq;
using System.Collections.Generic;

namespace _3.SearchForANumber
{
    public class Program
    {
        public static void Main()
        {
            var inputNumber = Console.ReadLine()
                .Trim()
                .Split(' ')
                .Select(int.Parse)
                .ToList();

            var arrayOfNumbers = Console.ReadLine()
                .Trim()
                .Split(' ')
                .Select(int.Parse)
                .ToArray();

            int takingNumberOfElements = arrayOfNumbers[0];
            int deletingNumberOfElements = arrayOfNumbers[1];
            int controllerNumber = arrayOfNumbers[2];

            List<int> numbersOfTakenElements = new List<int>();
            for (int i = 0; i < takingNumberOfElements; i++)
            {
                 numbersOfTakenElements.Add(inputNumber[i]);
            }

            numbersOfTakenElements.RemoveRange(0, deletingNumberOfElements);
            Console.WriteLine(numbersOfTakenElements.Contains(controllerNumber) ? "YES!" : "NO!");
        }
    }
}
