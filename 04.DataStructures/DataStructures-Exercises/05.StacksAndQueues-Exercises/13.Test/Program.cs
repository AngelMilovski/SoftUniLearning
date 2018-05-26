using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class Program
{
    static void Main(string[] args)
    {
        var input = Console.ReadLine();
        
        Dictionary<int,Students> test = new Dictionary<int,Students>();

        while (input != "end")
        {
            var klas = int.Parse(input);
            var name = Console.ReadLine();
            var grade = double.Parse(Console.ReadLine());

            if (!test.ContainsKey(klas))
            {
                test[klas] = new Students(null, null);
            }
            else
            {
                if (!test[klas].Name.Contains(name))
                {
                    test[klas].Name.Add(name);
                }
                else
                {
                    test[klas].Grade.Add(grade);
                }
                
            }
            input = Console.ReadLine();
        }
        

        foreach (var item in test)
        {
            int clas = item.Key;
            var children = item.Value;
            foreach (var child in children.Name)
            {
                Console.WriteLine(child);
            }
            
            foreach (var grade in children.Grade.OrderBy(g => g))
            {
                Console.WriteLine(grade);
            }
        }
        






    }
    private class Students
    {


        public Students Name { get; set; }

        public List<double> Grade { get; set; }

       

        public Students(Students name, List<double> grades)
        {
            this.Name = name;
            this.Grade = new List<double>();
        }
    }
}
