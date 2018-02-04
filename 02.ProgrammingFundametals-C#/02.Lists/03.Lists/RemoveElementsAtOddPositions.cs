using System;
using System.Collections.Generic;
using System.Linq;

public class RemoveElementsAtOddPositions
{
    public static void Main()
    {
        List<string> inputWords = Console.ReadLine()
            .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
            .ToList();
        List<string> words = new List<string>();
        for (int i = 1; i < inputWords.Count; i += 2)
        {
            words.Add(inputWords[i]);
        }
        string result = string.Join("", words);
        Console.WriteLine(result);
    }
}