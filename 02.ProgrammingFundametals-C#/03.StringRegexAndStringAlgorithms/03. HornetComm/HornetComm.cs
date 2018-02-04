using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using System.Text;

public class HornetComm
{
    public static void Main()
    {
        var input = Console.ReadLine();

        var messages = new List<string>();
        var broadcast = new List<string>();
        var messagePattern = @"^^(\d+) \<\-\> (\w+)$";
        var broadcastsPattern = @"^(\D+) \<\-\> (\w+)$";
        Regex broadcastRegex = new Regex(broadcastsPattern);
        Regex messageRegex = new Regex(messagePattern);
        while (input != "Hornet is Green")
        {
            if (broadcastRegex.IsMatch(input))
            {
                Match match = broadcastRegex.Match(input);
                string message = match.Groups[1].Value;
                string frequency = DecryptFrequency(match.Groups[2].Value);
                broadcast.Add(frequency + " -> " + message);
            }
            else if (messageRegex.IsMatch(input))
            {
                Match match = messageRegex.Match(input);
                string recipientCode = string.Join("", match.Groups[1].Value.Reverse());
                string message = match.Groups[2].Value;
                messages.Add(recipientCode + " -> " + message);
            }
            else
            {
                input = Console.ReadLine();
                continue;
            }
            input = Console.ReadLine();
        }
        Console.WriteLine("Broadcasts:");

        Console.WriteLine(broadcast.Any() ? string.Join("\n", broadcast) : "None");

        Console.WriteLine("Messages:");

        Console.WriteLine(messages.Any() ? string.Join("\n", messages) : "None");

    }

    private static string DecryptFrequency(string encryptedFrequency)
    {
        StringBuilder decryptedFrequency = new StringBuilder();
        foreach (var ch in encryptedFrequency)
        {
            if (char.IsUpper(ch))
            {
                decryptedFrequency.Append(char.ToLower(ch));
            }
            else if (char.IsLower(ch))
            {
                decryptedFrequency.Append(char.ToUpper(ch));
            }
            else
            {
                decryptedFrequency.Append(ch);
            }
        }
        return decryptedFrequency.ToString();
    }
}