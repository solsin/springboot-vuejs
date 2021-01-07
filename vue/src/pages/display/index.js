import Vue from 'vue'
import App from "./App.vue";
import router from "@/router/display.js";
import VueLazyload from 'vue-lazyload'

// import Swiper core and required components
import SwiperCore, { Navigation, Pagination, Scrollbar, A11y, Lazy } from 'swiper';
// install Swiper components
SwiperCore.use([Navigation, Pagination, Scrollbar, A11y, Lazy]);

// or with options
Vue.use(VueLazyload, {
  preLoad: 1.3,
  error: '/images/common/error.png',
  //loading: '/images/common/loading.gif',
  attempt: 1
})

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
