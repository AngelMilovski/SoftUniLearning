using System;
using System.Collections.Generic;
using System.Linq;

public class AnonymousCache
{
    public static void Main()
    {
        var dataSetList = new List<string>();
        var dataSetInfo = new Dictionary<string, Dictionary<string, long>>();
        var input = Console.ReadLine();

        while (input != "thetinggoesskrra")
        {
            var data = input
                    .Split(" ->|".ToCharArray(), StringSplitOptions.RemoveEmptyEntries);
            if (data.Length == 1)
            {
                dataSetList.Add(data[0]);
            }
            else
            {
                var dataKey = data[0];
                var dataSize = long.Parse(data[1]);
                var dataSet = data[2];

                if (!dataSetInfo.ContainsKey(dataSet))
                {
                    dataSetInfo[dataSet] = new Dictionary<string, long>();
                }
                dataSetInfo[dataSet][dataKey] = dataSize;
            }
            input = Console.ReadLine();
        }
        dataSetInfo
            .Where(e => !dataSetList.Contains(e.Key))
            .ToList()
            .ForEach(e => dataSetInfo.Remove(e.Key));

        if (dataSetInfo.Count > 0)
        {
            var result = dataSetInfo
                .OrderByDescending(s => s.Value.Sum(x => x.Value))
                .First();
            Console.WriteLine($"Data Set: {result.Key}, Total Size: {result.Value.Sum(x => x.Value)}");

            foreach (var item in result.Value)
            {
                Console.WriteLine($"$.{item.Value}");
            }
        }
    }
}