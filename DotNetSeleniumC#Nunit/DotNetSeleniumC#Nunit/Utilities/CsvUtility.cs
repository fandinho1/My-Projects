using CsvHelper;
using CsvHelper.Configuration;
using DotNetSelenium.Data;
using System.Globalization;

public class CsvUtility
{
    public static List<T> ReadCsvFile<T>(string filePath) where T : class
    {
        using (var reader = new StreamReader(filePath))
        using (var csv = new CsvReader(reader, new CsvConfiguration(CultureInfo.InvariantCulture)))
        {
            return csv.GetRecords<T>().ToList();
        }
    }
}