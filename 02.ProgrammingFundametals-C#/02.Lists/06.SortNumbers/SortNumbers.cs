using System;
using System.Linq;

public class SortNumbers
{
    public static void Main()
    {
        var inputNums = Console.ReadLine()
            .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
            .Select(double.Parse)
            .ToList();

        inputNums.Sort();
        var result = string.Join(" <= ", inputNums);
        Console.Write(result);
        Console.WriteLine();
    }
}

