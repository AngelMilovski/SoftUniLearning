using System;

public class AddTwoNumbers
{
    public static void Main()
    {
        short a = short.Parse(Console.ReadLine());
        short b = short.Parse(Console.ReadLine());
        Console.WriteLine($"{a} + {b} = {a + b}");
    }
}

