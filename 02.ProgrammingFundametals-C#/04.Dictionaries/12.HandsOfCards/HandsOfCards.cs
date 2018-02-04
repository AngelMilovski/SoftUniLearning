using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

public class HandsOfCards
{
    public static void Main()
    {
        var playerCards = new Dictionary<string, HashSet<string>>();
        var input = Console.ReadLine();

        while (input != "JOKER")
        {
            var personNameAndCards = Regex.Split(input, @":\s|,\s");

            if (!playerCards.ContainsKey(personNameAndCards[0]))
            {
                playerCards[personNameAndCards[0]] = new HashSet<string>();
            }
            for (int i = 0; i < personNameAndCards.Length - 1; i++)
            {
                playerCards[personNameAndCards[0]].Add(personNameAndCards[i + 1]);
            }
            input = Console.ReadLine();
        }
        var sum = 0;
        foreach (var cards in playerCards)
        {
            var name = cards.Key;
            var card = cards.Value;
            foreach (var symbol in card)
            {
                var value = 0;
                var powerOfCard = symbol.Substring(0, symbol.Length - 1);
                if (powerOfCard == "J" || powerOfCard == "Q" || powerOfCard == "K"
                    || powerOfCard == "A" || powerOfCard == "10")
                {
                    switch (powerOfCard)
                    {
                        case "10":
                            value = 10;
                            break;
                        case "J":
                            value = 11;
                            break;
                        case "Q":
                            value = 12;
                            break;
                        case "K":
                            value = 13;
                            break;
                        case "A":
                            value = 14;
                            break;
                    }
                }
                else
                {
                    value = byte.Parse(symbol[0].ToString());
                }

                switch (symbol[symbol.Length - 1])
                {
                    case 'S':
                        value *= 4;
                        break;
                    case 'H':
                        value *= 3;
                        break;
                    case 'D':
                        value *= 2;
                        break;
                    case 'C':
                        value *= 1;
                        break;
                }
                sum += value;
            }
            Console.WriteLine($"{name}: {sum}");
            sum = 0;
        }
    }
}