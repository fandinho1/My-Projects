using DotNetSelenium.Data;
using DotNetSelenium.pages;
using DotNetSelenium.Pages;

namespace DotNetSelenium.Tests
{
    [TestFixture]
    public class WebTableTest : BaseTest
    {
        private WebTablePage _webTablePage;
        private HomePage _homePage;
        private ElementsPage _elementsPage;


        [SetUp]
        public void SetUp()
        {
            _homePage = new HomePage(Driver);
            _elementsPage = new ElementsPage(Driver);
            _webTablePage = new WebTablePage(Driver);
            _homePage.GoToElementsPage();
            _elementsPage.GoToWebTablesPage();

        }

        [Test]
        [TestCase("Alden", "Alden Modified")]
        public void EditFirstName(string actualName, string newName)
        {
            _webTablePage.EditFirstName(actualName, newName);
            _webTablePage.VerifyNewName(newName);
        }

        [Test]
        [TestCaseSource(nameof(GetCsvWebTableData))]
        public void EditFirstNameUsingCsvData(WebTableData webTableData)
        {
            _webTablePage.EditFirstName("Kierra", webTableData.FirstName);
            _webTablePage.VerifyNewName(webTableData.FirstName);
        }

        //Source of test data from CSV
        public static IEnumerable<WebTableData> GetCsvWebTableData()
        {
            return CsvUtility.ReadCsvFile<WebTableData>(Path.Combine(AppDomain.CurrentDomain.BaseDirectory, "Data", "WebTableData.csv"));
        }
    }
}
