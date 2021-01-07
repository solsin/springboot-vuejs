module.exports = {
  outputDir: "../src/main/resources/static",
  //indexPath: "../static/index.html",
  devServer: {
    port: 9000,
    proxy: {
        "/api": {
            target: "http://localhost:9001"
        }
    }
  },
  chainWebpack: config => {
    const svgRule = config.module.rule("svg");
    svgRule.uses.clear();
    svgRule.use("vue-svg-loader").loader("vue-svg-loader");
  },
  pages: {
    display: {
      entry: 'src/pages/display/index.js',
      template: 'public/display.html',
      filename: 'build/home.html'
    },
    order: {
        entry: 'src/pages/order/index.js',
        template: 'public/order.html',
        filename: 'build/order.html',
        title: 'Order Page'
    },
  },
  css: {
    loaderOptions: {
      // by default the `sass` option will apply to both syntaxes
      // because `scss` syntax is also processed by sass-loader underlyingly
      // but when configuring the `prependData` option
      // `scss` syntax requires an semicolon at the end of a statement, while `sass` syntax requires none
      // in that case, we can target the `scss` syntax separately using the `scss` option
      scss: {
        additionalData: `@import "~@/components/variables.scss";`
      }
    }
  },
};
