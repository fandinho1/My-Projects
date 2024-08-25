using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Edge;
using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using OpenQA.Selenium.Firefox;

namespace DotNetSelenium.Utilities
{
    public class CreateWebDriverUtility
    {

        public static IWebDriver CreateWebDriver(string browser)
        {
            switch (browser.ToLower())
            {
                case "chrome":
                    return new ChromeDriver();
                case "edge":
                    return new EdgeDriver();
                case "firefox":
                    return new FirefoxDriver();
                default:
                    throw new ArgumentException($"Unsupported browser: {browser}");
            }
        }
    }
}
