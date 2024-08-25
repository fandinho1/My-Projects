using DotNetSelenium.pages;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using DotNetSelenium.Utilities;
using DotNetSelenium.Data;
using NUnit.Framework.Interfaces;
using Microsoft.Extensions.Configuration;

namespace DotNetSelenium.Tests
{
    [TestFixture]
    public class TextBoxTest : BaseTest
    {
        private HomePage _homePage;
        private ElementsPage _elementsPage;
        private TextBoxPage _textBoxPage;

        [SetUp]
        public void Setup()
        {
            _homePage = new HomePage(Driver);
            _elementsPage = new ElementsPage(Driver);
            _textBoxPage = new TextBoxPage(Driver);
        }

        [Test]
        [TestCase("user Test", "email@test", "current address test", "permanent address test")]
        public void SubmitFormUsingTestCaseData(string name, string email, string currentAddress, string permanentAddress)
        {
            _homePage.GoToElementsPage();
            _elementsPage.GoToTexBoxForm();
            _textBoxPage.FillAllPersonalData(name, email, currentAddress, permanentAddress);
        }

        [Test]
        [TestCaseSource(nameof(GetCsvTextBoxData))]
        public void SubmitFormUsingCsv(TextBoxData textBoxData)
        {
            _homePage.GoToElementsPage();
            _elementsPage.GoToTexBoxForm();
            _textBoxPage.FillAllPersonalData(textBoxData.Name, textBoxData.Email, textBoxData.CurrentAddress, textBoxData.PermanentAddress);
        }

        //Source of test data from CSV
        public static IEnumerable<TextBoxData> GetCsvTextBoxData()
        {
            return CsvUtility.ReadCsvFile<TextBoxData>(Path.Combine(AppDomain.CurrentDomain.BaseDirectory, "Data", "TextBoxData.csv"));
        }

    }
}