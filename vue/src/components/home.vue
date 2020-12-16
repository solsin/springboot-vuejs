<template>
  <div>
    <home1></home1>
    <home2></home2>
    <home3></home3>
  </div>
</template>

<script>
  // import Swiper core and required components
  import SwiperCore, { Navigation, Pagination, Scrollbar, A11y } from 'swiper';
  // install Swiper components
  SwiperCore.use([Navigation, Pagination, Scrollbar, A11y]);
  import axios from 'axios'
  import home1 from './home/home1.vue'
  import home2 from './home/home2.vue'
  import home3 from './home/home3.vue'
  
  export default {
    components: {
      home1,home2,home3
    },
    data () {
      return {
        loading: true,
        errored: false
      }
    },
    mounted() {
      var 
      axios
        .get('/api/main')
        .then(response => {
          home1.entity.slide = response.data.home1
        })
        .catch(error => {
          console.log(error)
          this.errored = true
        })
        .finally(() => this.loading = false)
    }
  }
</script>