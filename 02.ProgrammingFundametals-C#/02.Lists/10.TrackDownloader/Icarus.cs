using System;
using System.Linq;

public class Icarus
{
    public static void Main()
    {
        int[] arrayOfInt = Console.ReadLine()
            .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
            .Select(int.Parse)
            .ToArray();
        int startPosition = int.Parse(Console.ReadLine());
        string commands = Console.ReadLine();
        
        int damage = 1;
        while (commands != "Supernova")
        {
            string[] command = commands
                .Split(' ');
            string directions = command[0];
            int steps = int.Parse(command[1]);
            switch (directions)
            {
                case "left":
                    while (steps > 0)
                    {
                        startPosition--;
                        if (startPosition < 0)
                        {
                            startPosition = arrayOfInt.Length - 1;
                            damage++;
                        }
                        arrayOfInt[startPosition] -= damage;
                        steps--;
                    }
                    break;
                case "right":
                    while (steps > 0)
                    {
                        startPosition++;
                        if (startPosition > arrayOfInt.Length - 1)
                        {
                            startPosition = 0;
                            damage++;
                        }
                        arrayOfInt[startPosition] -= damage;
                        steps--;
                    }
                    break;
            }
            commands = Console.ReadLine();
        }
        string result = string.Join(" ", arrayOfInt);
        Console.WriteLine(result);
    } 
}