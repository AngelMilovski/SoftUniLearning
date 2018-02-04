using System;
using System.Collections.Generic;
using System.Linq;

public class AnonymousThreat
{
    public static void Main()
    {
        List<string> words = ArrayOfData();
        var commands = Console.ReadLine();

        while (commands != "3:1")
        {
            var tokens = commands
                .Split(' ');
            var command = tokens[0];

            switch (command)
            {
                case "merge":
                    CommandMerge(words, tokens);
                    break;
                case "divide":
                    CommandDivide(words, tokens);
                    break;
            }
            commands = Console.ReadLine();
        }
        Console.WriteLine(string.Join(" ", words));
    }

    private static List<string> ArrayOfData()
    {
        return Console.ReadLine()
            .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
            .ToList();
    }

    private static void CommandMerge(List<string> words, string[] tokens)
    {
        var startIndex = int.Parse(tokens[1]);
        var endIndex = int.Parse(tokens[2]);
        StartAndEndIndexInArray(words, ref startIndex, ref endIndex);
        var elementsForMerge = new List<string>();

        for (int i = startIndex; i <= endIndex; i++)
        {
            elementsForMerge.Add(words[i]);
        }
        string mergedElements = string.Empty;
        for (int i = 0; i < elementsForMerge.Count; i++)
        {
            mergedElements += elementsForMerge[i];
        }
        if (elementsForMerge.Count != 0)
        {
            words.RemoveRange(startIndex, (endIndex - startIndex) + 1);
            words.Insert(startIndex, mergedElements);
        }

    }

    private static void StartAndEndIndexInArray(List<string> arrayOfData, ref int startIndex, ref int endIndex)
    {
        if (startIndex < 0)
        {
            startIndex = 0;
        }
        if (endIndex > arrayOfData.Count - 1)
        {
            endIndex = arrayOfData.Count - 1;
        }
    }

    private static void CommandDivide(List<string> words, string[] tokens)
    {
        var index = int.Parse(tokens[1]);
        var partitions = int.Parse(tokens[2]);
        string word = words[index];

        var wordPartitions = new List<string>();
        int divide = word.Length / partitions;

        for (int i = 0; i < partitions; i++)
        {
            if (i == partitions - 1)
            {
                wordPartitions.Add(word.Substring(i * divide));
            }
            else
            {
                wordPartitions.Add(word.Substring(i * divide, divide));
            }
        }

        words.RemoveAt(index);
        words.InsertRange(index, wordPartitions);
    }
}