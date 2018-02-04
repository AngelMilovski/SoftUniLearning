using System;
using System.Text;

public class CharacterStats
{
    public static void Main()
    {
        string name = Console.ReadLine();
        byte currentHealt = byte.Parse(Console.ReadLine());
        byte maxHealt = byte.Parse(Console.ReadLine());
        byte currentEnergy = byte.Parse(Console.ReadLine());
        byte maxEnergy = byte.Parse(Console.ReadLine());

        Console.WriteLine("Name: " + name);
        Console.WriteLine("Health: |{0}{1}|",
            repeatStr("|", currentHealt),
            repeatStr(".", maxHealt - currentHealt));
        Console.WriteLine("Energy: |{0}{1}|",
            repeatStr("|", currentEnergy),
            repeatStr(".", maxEnergy - currentEnergy));
    }

    private static string repeatStr(string symbol, int count)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++)
        {
            sb.Append(symbol);
        }
        return sb.ToString();
    }
}

