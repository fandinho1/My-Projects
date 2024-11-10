import { Browser, chromium, firefox, webkit } from 'playwright';

export async function launchBrowser(browserName: string): Promise<Browser> {
  switch (browserName) {
    case 'firefox':
      return await firefox.launch({ headless: false });
    case 'msedge':
      return await chromium.launch({ headless: false, channel: 'msedge' });
    case 'chrome':
      return await chromium.launch({ headless: false, channel: 'chrome' });
    default:
      return await chromium.launch({ headless: false });
  }
}