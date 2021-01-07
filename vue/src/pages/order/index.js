import Vue from 'vue'
import Order from '@/views/order/'

Vue.config.productionTip = false

new Vue({
  render: h => h(Order)
}).$mount('#app')
