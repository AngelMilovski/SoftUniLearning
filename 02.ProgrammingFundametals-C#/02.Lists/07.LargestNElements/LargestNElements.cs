using System;
using System.Linq;

public class LargestNElements
{
    public static void Main()
    {
        var inputNums = Console.ReadLine()
            .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
            .Select(int.Parse)
            .ToList();
        int printNElements = int.Parse(Console.ReadLine());

        inputNums.Sort();
        inputNums.Reverse();
        for (int i = 0; i < printNElements; i++)
        {
            Console.Write(inputNums[i] + " ");
        }
        Console.WriteLine();
    }
}