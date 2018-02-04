using System;
using System.Collections.Generic;

public class TearListInHalf
{
    public static void Main()
    {
        var inputNums = Console.ReadLine()
            .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
        var skippedIndex = inputNums.Length / 2;
        var upperRow = new List<string>();
        var lowerRow = new List<string>();

        for (int i = 0; i < inputNums.Length / 2; i++)
        {
            lowerRow.Add(inputNums[i]);
            upperRow.Add(inputNums[inputNums.Length - 1 - i]);
        }
        upperRow.Reverse();
        var allDigits = new List<string>();
        
        for (int i = 0; i < upperRow.Count; i++)
        {
            var getOneDigit = upperRow[i].ToCharArray();
            for (int j = 0; j < getOneDigit.Length; j++)
            {
                allDigits.Add(getOneDigit[j].ToString());
            }
        }
        for (int i = 0; i < allDigits.Count; i += 3)
        {
            for (int j = 0; j < 1; j++)
            {
                allDigits.Insert(i + 1, lowerRow[j]);
                lowerRow.Remove(lowerRow[j]);
            }
        }
        var result = string.Join(" ", allDigits);
        Console.WriteLine(result);
    }
}