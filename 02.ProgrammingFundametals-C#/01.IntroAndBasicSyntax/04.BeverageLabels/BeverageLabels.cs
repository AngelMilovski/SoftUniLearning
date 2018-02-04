using System;

public class BeverageLabels
{
    public static void Main()
    {
        string name = Console.ReadLine();
        ushort volume = ushort.Parse(Console.ReadLine());
        ushort energyContent = ushort.Parse(Console.ReadLine());
        byte sugarContent = byte.Parse(Console.ReadLine());

        Console.WriteLine("{0}ml {1}:", volume, name);
        Console.WriteLine("{0}kcal, {1}g sugars",
            GetKcalContentInVolume(volume, energyContent),
            GetSugarInVolume(volume, sugarContent));
    }

    private static double GetSugarInVolume(double volume, double sugarContent)
    {
        double sugarInVolume = (volume * sugarContent) / 100;
        return sugarInVolume;
    }

    private static double GetKcalContentInVolume(double volume, double energyContent)
    {
        double kcal = (energyContent * volume) / 100;
        return kcal;
    }
}

