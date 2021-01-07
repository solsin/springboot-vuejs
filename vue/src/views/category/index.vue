<template>
  <div>
    <div v-if="loading" class="article-preview">loading...</div>
    <div>
      <p>전시목록</p>
    </div>
  </div>
</template>

<script>
  // import Swiper core and required components
  import SwiperCore, { Navigation, Pagination, Scrollbar, A11y } from 'swiper';
  // install Swiper components
  SwiperCore.use([Navigation, Pagination, Scrollbar, A11y]);
  import axios from 'axios'
  // import corner1 from './corner1.vue'
  // import corner2 from './corner2.vue'
  // import corner3 from './corner3.vue'

  export default {
    components: {
      //corner1,corner2,corner3
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
