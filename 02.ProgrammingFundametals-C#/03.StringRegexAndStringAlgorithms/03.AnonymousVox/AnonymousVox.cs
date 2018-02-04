using System;
using System.Linq;
using System.Text.RegularExpressions;

public class AnonymousVox
{
    public static void Main()
    {
        string input = Console.ReadLine();
        string value = Console.ReadLine();
        var placeholder = Regex.Split(value, "[{}]")
            .Where(p => p != "")
            .ToArray();
            
        string pattern = @"([A-Za-z]+)(.*)(\1)";
        MatchCollection matches = Regex.Matches(input, pattern);

        var count = 0;
        foreach (Match item in matches)
        {
            string newPlaceholder = item.Groups[1] + placeholder[count++] + item.Groups[3];
            input = input.Replace(item.Value, newPlaceholder);
        }
        Console.WriteLine(input);
    }
}