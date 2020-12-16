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
    index: {
      // entry for the page
      entry: 'src/pages/index/main.js',
      // the source template
      template: 'public/index.html',
      // output as dist/index.html
      filename: 'index.html'
    },
    home: {
      entry: 'src/pages/home/main.js',
      template: 'public/home.html',
      filename: 'home.html'
    },
    order: {
        entry: 'src/pages/order/main.js',
        template: 'public/order.html',
        filename: 'order.html',
        title: 'Order Page'
    }
  }
  // 메인/상품리스트,상품상세
  // 장바구니/주문/주문결과
  // 마이페이지
};