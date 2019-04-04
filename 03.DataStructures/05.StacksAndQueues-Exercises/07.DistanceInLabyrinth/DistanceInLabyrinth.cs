using System;
using System.Collections.Generic;

public class DistanceInLabyrinth
{
    public static void Main()
    {
        int size = int.Parse(Console.ReadLine());
        int[,] emptyMatrix = new int[size, size];

        int startRow = 0;
        int startCol = 0;

        int startValue = -2;
        int blockValue = -1;

        for (int col = 0; col < size; col++)
        {
            char[] symbol = Console.ReadLine().ToCharArray();

            for (int row = 0; row < size; row++)
            {
                if (symbol[row] == '*')
                {
                    startCol = col;
                    startRow = row;
                    emptyMatrix[col, row] = startValue;
                }
                else
                {
                    emptyMatrix[col, row] = symbol[row] == 'x'
                        ? blockValue : 0;
                }
            }
        }
        // get full matrix
        var fullMatrix = GetFullMatrix(emptyMatrix, startCol, startRow, size);
        
        //print the matrix
        PrintMatrix(fullMatrix, size, startValue, blockValue);
    }

    private static int[,] GetFullMatrix(int[,] emptyMatrix, int startCol, int startRow, int size)
    {
        var queue = new Queue<Cell>();
        queue.Enqueue(new Cell(startCol, startRow));
        emptyMatrix[startCol, startRow] = 0;
        while (queue.Count > 0)
        {
            var current = queue.Dequeue();

            if (current.Row + 1 < size && emptyMatrix[current.Col, current.Row + 1] == 0)
            {
                queue.Enqueue(new Cell(current.Col, current.Row + 1));
                emptyMatrix[current.Col, current.Row + 1] += emptyMatrix[current.Col, current.Row] + 1;
            }
            if (current.Row - 1 >= 0 && emptyMatrix[current.Col, current.Row - 1] == 0)
            {
                queue.Enqueue(new Cell(current.Col, current.Row - 1));
                emptyMatrix[current.Col, current.Row - 1] += emptyMatrix[current.Col, current.Row] + 1;
            }
            if (current.Col + 1 < size && emptyMatrix[current.Col + 1, current.Row] == 0)
            {
                queue.Enqueue(new Cell(current.Col + 1, current.Row));
                emptyMatrix[current.Col + 1, current.Row] += emptyMatrix[current.Col, current.Row] + 1;
            }
            if (current.Col - 1 >= 0 && emptyMatrix[current.Col - 1, current.Row] == 0)
            {
                queue.Enqueue(new Cell(current.Col - 1, current.Row));
                emptyMatrix[current.Col - 1, current.Row] += emptyMatrix[current.Col, current.Row] + 1;
            }
        }
        emptyMatrix[startCol, startRow] = -2;

        return emptyMatrix;


    }

    private static void PrintMatrix(int[,] matrix, int size, int startValue, int blockValue)
    {
        for (int col = 0; col < size; col++)
        {
            for (int row = 0; row < size; row++)
            {
                if (matrix[col, row] == startValue)
                {
                    Console.Write("*");
                }
                else if (matrix[col, row] == blockValue)
                {
                    Console.Write("x");
                }
                else if (matrix[col, row] == 0)
                {
                    Console.Write("u");
                }
                else
                {
                    Console.Write(matrix[col, row]);
                }
            }
            Console.WriteLine();
        }
    }
}

public class Cell
{
    public int Col { get; set; }

    public int Row { get; set; }

    public Cell(int col, int row)
    {
        this.Col = col;
        this.Row = row;
    }
}