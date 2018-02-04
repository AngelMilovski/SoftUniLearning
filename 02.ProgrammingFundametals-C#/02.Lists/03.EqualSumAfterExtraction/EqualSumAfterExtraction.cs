using System;
using System.Linq;

public class EqualSumAfterExtraction
{
    public static void Main()
    {
        var firstLine = Console.ReadLine()
            .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
            .Select(int.Parse)
            .ToList();
        var secondLine = Console.ReadLine()
            .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
            .Select(int.Parse)
            .ToList();
    
        var sumFromFirstLine = 0;

        for (int i = 0; i < firstLine.Count; i++)
        {
            var currentNum = firstLine[i];
            sumFromFirstLine += currentNum;
            secondLine.RemoveAll(n => n == currentNum);
        }
        var sumFromSecondLine = 0;
        foreach (var num in secondLine)
        {
            sumFromSecondLine += num;
        }
        if (sumFromFirstLine == sumFromSecondLine)
        {
            Console.WriteLine("Yes. Sum: {0}", sumFromFirstLine);
        }
        else
        {
            var diffFromSums = Math.Abs(sumFromFirstLine - sumFromSecondLine);
            Console.WriteLine("No. Diff: {0}", diffFromSums);
        }
    }
}