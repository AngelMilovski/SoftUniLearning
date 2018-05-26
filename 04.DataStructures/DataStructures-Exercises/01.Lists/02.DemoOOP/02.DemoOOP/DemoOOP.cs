using System;

public class DemoOOP
{
    public static void Main()
    {
        var r = new Rectangle(50, 40);
        var area = r.Area;

        //Print rect with overrite
        Console.WriteLine(r);

        //Print without overrite
        Console.WriteLine("Rect ({0}, {1})", r.Width, r.Heigth);

        //Print area
        Console.WriteLine(area);
    }
} 