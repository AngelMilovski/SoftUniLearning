using System;
using System.Collections.Generic;

public class PhonebookUpgrade
{
    public static void Main()
    {
        var phonebook = new SortedDictionary<string, string>();
        var result = new List<string>();
        var input = Console.ReadLine();

        while (input != "END")
        {
            var command = input
                    .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
            switch (command[0])
            {
                case "A":
                    var name = command[1];
                    var number = command[2];
                    if (!phonebook.ContainsKey(name))
                    {
                        phonebook[name] = string.Empty;
                    }
                    phonebook[name] = number;
                    break;
                case "S":
                    var searchingName = command[1];
                    if (phonebook.ContainsKey(searchingName))
                    {
                        result.Add($"{searchingName} -> {phonebook[searchingName]}");
                    }
                    else
                    {
                        result.Add($"Contact {searchingName} does not exist.");
                    }
                    break;
                case "ListAll":
                    foreach (var kvp in phonebook)
                    {
                        result.Add($"{kvp.Key} -> {kvp.Value}");
                    }
                    break;
            }
            input = Console.ReadLine();
        }
        var output = string.Join(Environment.NewLine, result);
        Console.WriteLine(output);
    }
}