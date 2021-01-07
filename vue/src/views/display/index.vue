<template>
  <div>
    <div v-if="loading" class="article-preview">loading...</div>
    <div>
      <corner1 :slides="ds.corner1"></corner1>
      <corner2 :slides="ds.corner2"></corner2>
      <corner3 :slides="ds.corner1"></corner3>
    </div>
  </div>
</template>

<script>
  import axios from 'axios'
  import corner1 from './corner1.vue'
  import corner2 from './corner2.vue'
  import corner3 from './corner3.vue'

  export default {
    components: {
      corner1,corner2,corner3
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
