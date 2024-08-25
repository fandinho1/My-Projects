using DotNetSelenium.Data;

namespace DotNetSelenium.Utilities
{
    public static class CsvDataReader
    {
        public static IEnumerable<object[]> GetCsvData<T>(string fileName) where T : class
        { 
            string filePath = Path.Combine(AppDomain.CurrentDomain.BaseDirectory, "Data", fileName);

            var records= CsvUtility.ReadCsvFile<T>(filePath);
            return records.Select(record => new object[] { record });
        }

      

    }
}
