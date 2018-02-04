namespace _12.SplitByWordCasing
{
    using System;
    using System.Collections.Generic;
    using System.Text;
    using System.Text.RegularExpressions;
    using System.Linq;

    class SplitByWordCasing
    {
        public static void Main()
        {

            var words = Console.ReadLine()
                .Split(new char[] { ' ',',', ':', ';', '\'', '"', '\\', '/', '!', '.', '[', ']', ')', '(' }
                , StringSplitOptions.RemoveEmptyEntries)
                .ToList();
            
            
            var lowerCase = new List<string>();
            var upperCase = new List<string>();
            var mixedCase = new List<string>();

            foreach (var word in words)
            {
                if (word.All(char.IsUpper))
                {
                    upperCase.Add(word);
                }
                else if (word.All(char.IsLower))
                {
                    lowerCase.Add(word);
                }
                else
                {
                    mixedCase.Add(word);
                }
            }
            Console.WriteLine("Lower-case: {0}", string.Join(", ", lowerCase));
            Console.WriteLine("Mixed-case: {0}", string.Join(", ", mixedCase));
            Console.WriteLine("Upper-case: {0}", string.Join(", ", upperCase));
        }
    }
}
