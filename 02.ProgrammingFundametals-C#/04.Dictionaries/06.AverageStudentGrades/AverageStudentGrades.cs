using System;
using System.Collections.Generic;
using System.Linq;

public class AverageStudentGrades
{
    public static void Main()
    {
        var grades = new Dictionary<string, List<double>>();
        var n = int.Parse(Console.ReadLine());
        for (int i = 0; i < n; i++)
        {
            var studentsAndGrades = Console.ReadLine()
                .Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
            var studentName = studentsAndGrades[0];
            var studentGrade = double.Parse(studentsAndGrades[1]);

            if (!grades.ContainsKey(studentName))
            {
                grades[studentName] = new List<double>();
            }
            grades[studentName].Add(studentGrade);
        }

        foreach (var pair in grades)
        {
            var name = pair.Key;
            var studentGrade = pair.Value;
            var avg = studentGrade.Average();
            Console.Write($"{name} -> ");
            foreach (var grade in studentGrade)
            {
                Console.Write($"{grade:F2} ");
            }
            Console.WriteLine($"(avg: {avg:F2})");
        }    
    }
}