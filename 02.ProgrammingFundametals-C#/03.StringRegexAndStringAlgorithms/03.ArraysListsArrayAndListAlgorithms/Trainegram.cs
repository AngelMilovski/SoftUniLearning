using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

public class Trainegram
{
    public static void Main()
    {
        string input = Console.ReadLine();
        string pattern = @"^(<\[[^A-Za-z0-9\n]*]\.)(\.\[[A-Za-z0-9]*]\.)*$";
        Regex train = new Regex(pattern);
        var validTrain = new List<string>();

        while (input != "Traincode!")
        {
            if (train.IsMatch(input))
            {
                Match match = train.Match(input);
                validTrain.Add(match.Value);
            }
            input = Console.ReadLine();
        }
        string result = string.Join(Environment.NewLine, validTrain);
        Console.WriteLine(result);

        // Fenix Grid
    }
}