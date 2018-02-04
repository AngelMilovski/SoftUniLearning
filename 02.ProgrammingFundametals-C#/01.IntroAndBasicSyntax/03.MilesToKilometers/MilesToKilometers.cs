using System;

public class MilesToKilometers
{
    public static void Main()
    {
        float miles = float.Parse(Console.ReadLine());
        ConvertToKm(miles);
    }

    private static void ConvertToKm(float miles)
    {
        double fromMileToKm = miles * 1.60934;
        Console.WriteLine("{0:F}", fromMileToKm);
    }
}

