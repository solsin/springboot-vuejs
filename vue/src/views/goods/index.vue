<template>
  <div>
    <div v-if="loading" class="article-preview">loading...</div>
    <div>
      <p>상품상세</p>
    </div>
  </div>
</template>

<script>
  // import Swiper core and required components
  import SwiperCore, { Navigation, Pagination, Scrollbar, A11y } from 'swiper';
  // install Swiper components
  SwiperCore.use([Navigation, Pagination, Scrollbar, A11y]);
  import axios from 'axios'

  export default {
    components: {
      
    },
    data () {
      return {
        loading: true,
        errored: false,
        ds: [] // default data container
      }
    },
    mounted() {
      axios
        .get('/api/main')
        .then(response => {
          this.ds = response.data
        })
        .catch(error => {
          console.log(error)
          this.errored = true
        })
        .finally(() => this.loading = false)
    }
  }
</script>
