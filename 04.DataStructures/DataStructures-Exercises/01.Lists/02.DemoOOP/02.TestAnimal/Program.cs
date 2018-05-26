using System;
using Dogs;

public class Program
{
    public static void Main()
    {
        Dog d = new Dog("Black");

        Console.WriteLine(d.Bark());

        Dog betty = new Dog("Betty", "breed - street special");
        betty.Breed = "English Dog";
        Console.WriteLine(betty.Bark());

        var dogsName = "Djoni";
        var djoni = new Dog(dogsName);
        //Print with override
        Console.WriteLine(djoni);

    }
}