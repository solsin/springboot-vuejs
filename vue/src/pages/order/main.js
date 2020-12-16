import Vue from 'vue'
import Order from '@/components/order.vue'

Vue.config.productionTip = false

new Vue({
  render: h => h(Order)
}).$mount('#app')