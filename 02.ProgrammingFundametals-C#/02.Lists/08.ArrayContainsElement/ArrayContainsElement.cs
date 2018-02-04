using System;
using System.Linq;

public class ArrayContainsElement
{
    public static void Main()
    {
        var inputNums = Console.ReadLine()
         .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
         .Select(int.Parse)
         .ToList();
        int n = int.Parse(Console.ReadLine());
        bool isContain = false;

        for (int i = 0; i < inputNums.Count; i++)
        {
            var current = inputNums[i];
            if (current == n)
            {
                isContain = true;
                break;
            }
        }
        Console.WriteLine(isContain ? "yes" : "no");
    }
}