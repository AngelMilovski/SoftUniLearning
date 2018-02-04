using System;
using System.Collections.Generic;
using System.Linq;


namespace _05.ArrayManilupator
{
    public class Program
    {
        public static void Main()
        {
            var numbers = "1 2 3 4 5"
                 .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                 .Select(int.Parse)
                 .ToList();
            var command = Console.ReadLine();
            while(command != "print")
            {
                var tokens = command.Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
                switch (tokens[0])
                {
                    case "add":
                        var index = int.Parse(tokens[1]);
                        var element = int.Parse(tokens[2]);
                        numbers.Insert(index, element);
                        break;
                    case "addMany":
                        
                        index = int.Parse(tokens[1]);
                        element = int.Parse(tokens[2]);
                        for (int i = 0; i < command.Length - 2; i++)
                        {
                            numbers.Insert(index + i, element + i);
                        }
                        break;
                }
                command = Console.ReadLine();
            }
            var result = string.Join(", ", numbers);
        }
    }
}
