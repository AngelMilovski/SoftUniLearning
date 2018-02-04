namespace _10.RemoveNegativeAndReverse
{
    using System;
    using System.Collections.Generic;
    class RemoveNegativeAndReverse
    {
        public static void Main()
        {
            var input = Console.ReadLine()
                .Split(' ');
            var numbers = new List<int>();
            for (int i = 0; i < input.Length; i++)
            {
                numbers.Add(int.Parse(input[i]));
            }
            var numsForReverse = new List<int>();
            for (int i = 0; i < numbers.Count; i++)
            {
                if (numbers[i] > 0)
                {
                    numsForReverse.Add(numbers[i]);
                }
            }
            if (numsForReverse.Count == 0)
            {
                Console.WriteLine("empty");
            }
            else
            {
                var reversedNums = new int[numsForReverse.Count];
                for (int i = 0; i < reversedNums.Length; i++)
                {
                    reversedNums[i] = numsForReverse[numsForReverse.Count - 1 - i];
                }
                var result = string.Join(" ", reversedNums);
                Console.WriteLine(result);
            }
        }
    }
}
