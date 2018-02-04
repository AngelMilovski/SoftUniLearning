using System;

public class EmployeeData
{
    public static void Main()
    {
        string name = Console.ReadLine();
        byte age = byte.Parse(Console.ReadLine());
        int employeeID = int.Parse(Console.ReadLine());
        float salary = float.Parse(Console.ReadLine());

        Console.WriteLine("Name: " + name);
        Console.WriteLine("Age: " + age);
        Console.WriteLine("Employee ID: {0:D8}", employeeID);
        Console.WriteLine("Salary: {0:F2}", salary);
    }
}

