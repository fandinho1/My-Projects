const fs = require('fs');
const path = require('path');
const os = require('os');
const process = require('process'); 
const reporter = require('multiple-cucumber-html-reporter');

const jsonDir = path.resolve(__dirname, 'test-result/report');
const output = path.resolve(__dirname, 'test-result/report/cucumber-report.html');

const nodeVersion = process.version;
const osPlatform = os.platform();
const osVersion = os.release();
const currentDate = new Date().toLocaleString();
const deviceInfo = {
    hostname: os.hostname(),
    cpuModel: os.cpus()[0].model,
    cpuCores: os.cpus().length,
    totalMemoryGB: (os.totalmem() / (1024 ** 3)).toFixed(2),
    architecture: os.arch(),
  };

const browsers = ['chromium', 'firefox', 'msedge', 'chrome'];
browsers.forEach(browser => {
  const jsonFilePath = path.join(jsonDir, `cucumber-report-${browser}.json`);
  
  if (fs.existsSync(jsonFilePath)) {
    const jsonData = JSON.parse(fs.readFileSync(jsonFilePath, 'utf8'));
    if (jsonData.length > 0) {
      jsonData[0].metadata = {
        browser: {
          name: browser
        },
        device: `${deviceInfo.hostname} - ${deviceInfo.cpuModel}, ${deviceInfo.cpuCores} cores, ${deviceInfo.totalMemoryGB} GB RAM`,
        platform: {
          name: osPlatform,  
          version: osVersion 
        },
        node: {
          version: nodeVersion, 
          processID: process.pid  
        },
        executionDate: currentDate 
      };
    }

    fs.writeFileSync(jsonFilePath, JSON.stringify(jsonData, null, 2));
  }
});

reporter.generate({
  jsonDir: jsonDir,
  reportPath: output,
  reportSuiteAsScenarios: true,
  launchReport: true,
  theme: 'bootstrap',
});