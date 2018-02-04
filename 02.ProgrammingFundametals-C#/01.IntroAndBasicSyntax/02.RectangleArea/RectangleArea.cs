using System;

public class RectangleArea
{
    public static void Main()
    {
        float height = float.Parse(Console.ReadLine());
        float width = float.Parse(Console.ReadLine());

        Console.WriteLine("{0:F}", GetArea(height, width));
    }

    private static float GetArea(float height, float width)
    {
        float area = height * width;
        return area;
    }
}

