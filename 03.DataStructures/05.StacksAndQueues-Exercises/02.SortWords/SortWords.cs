using System;

public class SortWords
{
    public static void Main()
    {
        string[] input = Console.ReadLine()
            .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
        Array.Sort(input);
        string result = string.Join(" ", input);
        Console.WriteLine(result);
    }
}