using System;
using System.Collections.Generic;
using System.Linq;

public class ReverseNumbers
{
    public static void Main()
    {
        Stack<int> numbers = new Stack<int>();
        var input = Console.ReadLine()
            .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
            .Select(int.Parse)
            .ToArray();
        foreach (var number in input)
        {
            numbers.Push(number);
        }
        
        while(numbers.Count > 0)
        {
            var current = numbers.Pop();
            Console.Write(current + " ");
        }
        Console.WriteLine();
    }
}