using System;
using System.Collections.Generic;
using System.Linq;

public class PokemonDon_tGo
{
    public static void Main()
    {
        List<int> arrOfInt = Console.ReadLine()
            .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
            .Select(int.Parse)
            .ToList();
        long sum = 0;

        while (arrOfInt.Count > 0)
        {
            int value = 0;
            int indexForRemove = int.Parse(Console.ReadLine());
            if (indexForRemove < 0)
            {
                value = arrOfInt[0];
                sum += value;
                arrOfInt[0] = arrOfInt[arrOfInt.Count - 1];
            }
            else if (indexForRemove > arrOfInt.Count - 1)
            {
                value = arrOfInt[arrOfInt.Count - 1];
                sum += value;
                arrOfInt[arrOfInt.Count - 1] = arrOfInt[0];
            }
            else
            {
                value = arrOfInt[indexForRemove];
                arrOfInt.RemoveAt(indexForRemove);
                sum += value;
            }
            IncreaseOrDecreaseVolue(arrOfInt, value);
        }
        Console.WriteLine(sum);
    }

    private static void IncreaseOrDecreaseVolue(List<int> arrOfInt, int value)
    {
        for (int i = 0; i < arrOfInt.Count; i++)
        {
            int currentNum = arrOfInt[i];
            if (currentNum <= value)
            {
                arrOfInt[i] += value;
            }
            else
            {
                arrOfInt[i] -= value;
            }
        }
    }
}