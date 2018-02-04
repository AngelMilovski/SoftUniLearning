namespace _04.LongestIncreasingSubsequence
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    class LongestIncreasingSubsequence
    {
        public static void Main()
        {
            var nums = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToArray();
            int[] length = new int[nums.Length];
            int[] prev = new int[nums.Length];
            int maxLength = 0;
            int lastIndex = -1;

            for (int i = 0; i < nums.Length; i++)
            {
                length[i] = 1;
                prev[i] = -1;

                for (int j = 0; j < i; j++)
                {
                    if (nums[j] < nums[i] && length[j] >= length[i])
                    {
                        length[i] = 1 + length[j];
                        prev[i] = j;
                    }
                }

                if (length[i] > maxLength)
                {
                    maxLength = length[i];
                    lastIndex = i;
                }
            }

            var longestSeq = new List<int>();
            for (int i = 0; i < maxLength; i++)
            {
                longestSeq.Add(nums[lastIndex]);
                lastIndex = prev[lastIndex];
            }
            longestSeq.Reverse();
            Console.WriteLine(string.Join(" ", longestSeq));
        }
    }
}
