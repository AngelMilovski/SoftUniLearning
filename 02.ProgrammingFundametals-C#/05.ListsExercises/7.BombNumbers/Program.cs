using System;
using System.Collections.Generic;
using System.Linq;

namespace _7.BombNumbers
{
    public class Program
    {
        public static void Main()
        {
            var sequenceOfNumbers = Console.ReadLine()
                  .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                  .Select(int.Parse)
                  .ToList();
            var bombNumberAndPower = Console.ReadLine()
                 .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                  .Select(int.Parse)
                  .ToArray();

            int bombNum = bombNumberAndPower[0];
            int bombPower = bombNumberAndPower[1];
            

            for (int i = 0; i < sequenceOfNumbers.Count - 1; i++)
            {
                int current = sequenceOfNumbers[i];
                if (current == bombNum)
                {
                    for (int j = 1; j <= bombPower ; j++)
                    {
                        if (i - j >= 0)
                        {
                            sequenceOfNumbers[i - j] = 0;
                        }
                        else
                        {
                            break;
                        }
                        
                    }
                    for (int j = 1; j <= bombPower; j++)
                    {
                        if (i + j < sequenceOfNumbers.Count)
                        {
                            sequenceOfNumbers[i + j] = 0;
                        }
                        else
                        {
                            break;
                        }
                    }
                    sequenceOfNumbers[i] = 0;
                    
                }
            }
          
            int sum = sequenceOfNumbers.Sum();
		  //  int sum = 0;
          //  for (int i = 0; i < sequenceOfNumbers.Count; i++)
          //  {
          //      int numberForResult = sequenceOfNumbers[i];
          //      sum += numberForResult;
          //  }
            Console.WriteLine(sum);
        }
    }
}
