using System;
using System.Collections.Generic;


public class TrackDownloader
{
    public static void Main()
    {
        var blacklistedWords = Console.ReadLine()
            .Split(new[] { ' ' },StringSplitOptions.RemoveEmptyEntries);
        var fileNames = Console.ReadLine();
        var allFiles = new List<string>();
        
        while (fileNames != "end")
        {
            bool contain = false;
            for (int i = 0; i < blacklistedWords.Length; i++)
            {
                if (fileNames.Contains(blacklistedWords[i]))
                {
                    contain = true;
                    break;
                }
            }
            if (!contain)
            {
                allFiles.Add(fileNames);
            }
            fileNames = Console.ReadLine();
        }
        allFiles.Sort();
        foreach (var item in allFiles)
        {
            Console.WriteLine(item);
        }
    }
}