using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

public class UserLogs
{
    public static void Main()
    {
        var userData = new SortedDictionary<string, Dictionary<string, int>>();
        var pattern = @"\smessage=\'[^\n]*\'\s";
        var input = Console.ReadLine();

        while (input != "end")
        {
            var test = Regex.Split(input, pattern);
            var ip = test[0].Substring(3);
            var user = test[1].Substring(5);
            if (!userData.ContainsKey(user))
            {
                userData[user] = new Dictionary<string, int>();
            }
            if (!userData[user].ContainsKey(ip))
            {
                userData[user][ip] = 0;
            }
            userData[user][ip]++;

            input = Console.ReadLine();
        }

        foreach (var user in userData)
        {
            var result = new List<string>();
            var userName = user.Key;
            var IP = user.Value;
            Console.WriteLine($"{userName}: ");
            foreach (var kvp in IP)
            {
                result.Add($"{kvp.Key} => {kvp.Value}");
            }
            var output = string.Join(", ", result);
            Console.WriteLine($"{output}.");
        }
    }
}