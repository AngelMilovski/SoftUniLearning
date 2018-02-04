using System;

public class DebitCardNumber
{
    public static void Main()
    {
        short firstNum = short.Parse(Console.ReadLine());
        short secondNum = short.Parse(Console.ReadLine());
        short thirdNum = short.Parse(Console.ReadLine());
        short fourthNum = short.Parse(Console.ReadLine());

        Console.WriteLine("{0:D4} {1:D4} {2:D4} {3:D4}", firstNum, secondNum, thirdNum, fourthNum);
    }
}

