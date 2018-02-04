using System;
using System.Collections.Generic;
using System.Linq;

public class FixEmails
{
    public static void Main()
    {
        var emails = new Dictionary<string, string>();
        var name = Console.ReadLine();

        while (name != "stop")
        {
            var email = Console.ReadLine();
            if (email.Contains(".us") || email.Contains(".uk"))
            {
                name = Console.ReadLine();
                continue;
            }
            if (!emails.ContainsKey(name))
            {
                emails[name] = string.Empty;
            }
            emails[name] = email;
            name = Console.ReadLine();
        }
        foreach (var kvp in emails)
        {
            Console.WriteLine($"{kvp.Key} -> {kvp.Value}");
        }
    }
}