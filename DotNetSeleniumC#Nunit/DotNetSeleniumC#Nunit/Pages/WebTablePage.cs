using OpenQA.Selenium;

namespace DotNetSelenium.Pages
{
    public class WebTablePage
    {
        private IWebDriver _driver;

        public WebTablePage(IWebDriver driver)
        {
            _driver = driver;
        }

        private IWebElement EditBtn => _driver.FindElement(By.XPath("//span[@title='Edit']"));
        private IWebElement SearchInput => _driver.FindElement(By.Id("searchBox"));
        private IWebElement FirstNameInput => _driver.FindElement(By.Id("firstName"));
        private IWebElement SubmitBtn => _driver.FindElement(By.Id("submit"));

        private Dictionary<string, string> getTableDataAsDictionary()
        {
            var headers = _driver.FindElements(By.XPath("//div[@class='rt-thead -header']//div[@role='columnheader']"));
            var rowCells = _driver.FindElements(By.XPath("//div[@class='rt-tbody']//div[@class='rt-tr-group'][1]//div[@class='rt-td']"));

            var rowData = new Dictionary<string, string>();

            for (int i = 0; i < headers.Count; i++)
            {
                string headerText = headers[i].Text.Trim();
                string cellText = rowCells[i].Text.Trim();

                rowData[headerText] = cellText;
            }

            return rowData;
        }

        public void EditFirstName(string actualName, string newName)
        {
            SearchInput.Clear();
            SearchInput.SendKeys(actualName);
            SearchInput.SendKeys(Keys.Enter);
            EditBtn.Click();
            FirstNameInput.Clear();
            FirstNameInput.SendKeys(newName);
            SubmitBtn.Click();
        }

        public void VerifyNewName(string newName)
        {
            Assert.That(newName, Is.EqualTo(getTableDataAsDictionary()["First Name"]));
        }







    }
}
