using System;
using System.Linq;

public class NumberChecker
    {
    public static void Main()
    {
        try
        {
            int input = int.Parse(Console.ReadLine());
            Console.WriteLine("It is a number.");
        }
         catch (FormatException)
        {
        Console.WriteLine("Invalid input!");
        }
    }
}