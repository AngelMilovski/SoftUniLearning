using System;
using System.Collections.Generic;
using System.Linq;

public class FlipListSides
{
    public static void Main()
    {
        var inputNums = Console.ReadLine()
            .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
            .Select(int.Parse)
            .ToArray();
        var reversedNums = new List<int>();
        reversedNums.Add(inputNums[0]);

        for (int i = 1; i < inputNums.Length - 1; i++)
        {
            reversedNums.Add(inputNums[inputNums.Length - 1 - i]);
        }
        reversedNums.Add(inputNums[inputNums.Length - 1]);
        var result = string.Join(" ", reversedNums);
        Console.WriteLine(result);
    }
}