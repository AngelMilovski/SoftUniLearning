using System;
using System.Collections.Generic;
using System.Linq;

public class ArrayManipulator
{
    public static void Main()
    {
        var inputNums = Console.ReadLine()
            .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
            .Select(int.Parse)
            .ToList();

        string commands = Console.ReadLine();
        while (commands != "print")
        {
            string[] tokens = commands.Split(' ');
            string command = tokens[0];
            switch (command)
            {
                case "add":
                    int index = int.Parse(tokens[1]);
                    int element = int.Parse(tokens[2]);
                    inputNums.Insert(index, element);

                    break;
                case "addMany":
                    inputNums.InsertRange(int.Parse(tokens[1]), tokens.Skip(2)
                        .Select(int.Parse)
                        .ToArray());
                    break;
                case "contains":
                    int containsElement = int.Parse(tokens[1]);
                    Console.WriteLine(inputNums.IndexOf(containsElement));
                    
                    break;
                case "remove":
                    int indexForRemove = int.Parse(tokens[1]);
                    inputNums.RemoveAt(indexForRemove);
                    break;
                case "shift":
                    int position = int.Parse(tokens[1]);
                    position %= inputNums.Count;
                    var rem = inputNums.Take(position)
                        .ToList();
                    inputNums.RemoveRange(0, position);
                    inputNums.AddRange(rem);
                    break;
                case "sumPairs":
                    List<int> sumPairs = new List<int>();
                    for (int i = 0; i < inputNums.Count - 1; i++)
                    {
                        int sum = inputNums[i] + inputNums[i + 1];
                        inputNums[i] = sum;
                        inputNums.RemoveAt(i + 1);
                    }
                    if (inputNums.Count % 2 != 0)
                    {
                        sumPairs.Add(inputNums[inputNums.Count - 1]);
                    }
                    break;
            }
            commands = Console.ReadLine();
        }
        string result = string.Join(", ", inputNums);
        Console.WriteLine($"[{result}]");
    }
}