using System;
using System.Collections.Generic;

public class Phonebook
{
    public static void Main()
    {
        var input = Console.ReadLine();
        var phonebook = new Dictionary<string, string>();
        var result = new List<string>();

        while (input != "END")
        {
            var phonebookData = input
                    .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
            if (input.StartsWith("A"))
            {
                var name = phonebookData[1];
                var number = phonebookData[2];
                if (!phonebook.ContainsKey(name))
                {
                    phonebook[name] = string.Empty;
                }
                phonebook[name] = number;
            }
            else
            {
                var name = phonebookData[1];
                if (phonebook.ContainsKey(name))
                {
                    foreach (var nameAndNumber in phonebook)
                    {
                        if (nameAndNumber.Key == name)
                        {
                            result.Add($"{nameAndNumber.Key} -> {nameAndNumber.Value}");
                            break;
                        }
                        
                    }
                }
                else
                {
                    result.Add($"Contact {name} does not exist.");
                }
            }
            input = Console.ReadLine();
        }
        var output = string.Join(Environment.NewLine, result);
        Console.WriteLine(output);
    }
}