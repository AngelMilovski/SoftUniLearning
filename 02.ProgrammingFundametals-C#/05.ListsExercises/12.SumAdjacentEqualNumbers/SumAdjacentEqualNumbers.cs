namespace _12.SumAdjacentEqualNumbers
{
    using System;
    using System.Linq;
    using System.Collections.Generic;
    class SumAdjacentEqualNumbers
    {
        public static void Main()
        {

            var input = Console.ReadLine()
                .Split(' ')
                .Select(double.Parse)
                .ToList();


               for (int i = 1; i < input.Count; i++)
               {
                   double current = input[i];
                   double next = input[i - 1];
                   double sum = 0;

                       if (current == next)
                       {
                           sum = current + next;
                           input[i] = sum;
                           input.Remove(next);
                           i = 0;
                           continue;
                       }
               }
            var result = string.Join(" ", input);
            Console.WriteLine(result);

            
            var nums = new List<double>();
            for (int i = 0; i < input.Count; i++)
            {
                nums.Add(input[i]);
            }

            for (int i = 1; i < nums.Count; i++)
            {
                double current = nums[i];
                double next = nums[i - 1];
                double sum = 0;
                if (current == next)
                {
                    sum = current + next;
                    nums[i] = sum;
                    nums.Remove(current);
                    i = 0;
                    continue;
                }
                Console.WriteLine(string.Join(" ", nums));
            }
        }
    }
}
