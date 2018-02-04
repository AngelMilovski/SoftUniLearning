namespace _01.ListsExercises
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    public class MaxSequenceOfEqualElements
    {
        public static void Main()
        {
            var listOfNumber = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToList();
            var currentSequence = 1;
            var maxSeq = 1;
            var MaxSeqNum = 0;

            for (int i = 1; i < listOfNumber.Count; i++)
            {
                var current = listOfNumber[i];
                var previous = listOfNumber[i - 1];
                if (current == previous)
                {
                    currentSequence++;
                }
                else
                {
                    currentSequence = 1;
                }
                if (currentSequence > maxSeq)
                {
                    maxSeq = currentSequence;
                    MaxSeqNum = current;
                }
            }
            for (int i = 0; i < maxSeq; i++)
            {
                Console.Write(MaxSeqNum + " ");
            }
            Console.WriteLine();
        }
    }
}
