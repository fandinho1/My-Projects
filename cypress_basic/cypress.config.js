const { defineConfig } = require("cypress");

module.exports = defineConfig({
  projectId: 'zba8wk',
  chromeWebSecurity: false,
  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
  },
});
