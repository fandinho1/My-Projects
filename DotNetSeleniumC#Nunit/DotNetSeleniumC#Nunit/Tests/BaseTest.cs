using DotNetSelenium.Utilities;
using Microsoft.Extensions.Configuration;
using OpenQA.Selenium;

namespace DotNetSelenium.Tests
{
    public abstract class BaseTest
    {

        protected IWebDriver Driver;


        [SetUp]
        public void SetUp()
        {
            var config = new ConfigurationBuilder()
                .SetBasePath(AppDomain.CurrentDomain.BaseDirectory)
                .AddJsonFile("appsettings.json")
                .Build();
            Driver = CreateWebDriverUtility.CreateWebDriver(config["Browser"]);
            Driver.Navigate().GoToUrl("https://demoqa.com/");
            Driver.Manage().Window.Maximize();
        }

        [TearDown]
        public void TearDown()
        {
            Driver.Quit();
            Driver.Dispose();
        }
    }
}
