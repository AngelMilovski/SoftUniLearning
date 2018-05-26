using System;

public class Program
{
    public static void Main()
    {
        var heigth = 5;
        var width = 6;
        var area = Area(heigth, width);
        Console.WriteLine(area);
    }

    public static int Area(int heigth, int width)
    {
        var area = heigth * width;
        return area;
    }
}