namespace _11.AppendLists
{
    using System;
    using System.Collections.Generic;
    class AppendLists
    {
        public static void Main()
        {
            var input = Console.ReadLine()
                .Split('|');
            var text = new List<string>();
            for (int i = 0; i < input.Length; i++)
            {
                text.Add(input[input.Length - 1 - i].Trim());
            }
            Console.WriteLine(string.Join(" ", text));
        }
    }
}
