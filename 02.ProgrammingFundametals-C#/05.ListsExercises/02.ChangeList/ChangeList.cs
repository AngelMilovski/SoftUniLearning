namespace _02.ChangeList
{
    using System;
    using System.Linq;
    using System.Collections.Generic;
    public class ChangeList
    {
        public static void Main()
        {
            List<int> numbers = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToList();
            var command = Console.ReadLine();

            while (command != "Even" && command != "Odd")
            {
                var commandArqs = command
                    .Split(' ');
                var currentCommand = commandArqs[0];
                var element = int.Parse(commandArqs[1]);
                
                switch (currentCommand)
                {
                    case "Delete":
                        numbers.RemoveAll(n => n == element);
                        break;
                    case "Insert":
                        var index = int.Parse(commandArqs[2]);
                        numbers.Insert(index, element);
                        break;
                }
                command = Console.ReadLine();
            }
           
            if (command == "Even")
            {
                Console.WriteLine(GetEvenNumbers(numbers));
            }
            else if (command == "Odd")
            {
                Console.WriteLine(GetOddNumbers(numbers));
            }
            Console.WriteLine();
        }

        private static string GetOddNumbers(List<int> numbers)
        {
            return string.Join(" ", numbers.Where(n => n % 2 != 0));
        }

        private static string GetEvenNumbers(List<int> numbers)
        {
            return string.Join(" ", numbers.Where(n => n % 2 == 0));
        }
    }
}
