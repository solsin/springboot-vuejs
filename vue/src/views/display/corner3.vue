<template>
  <div>
    hello
  </div>
</template>

<script>

  export default {
    name: 'corner3',
    title: 'Loop mode / Infinite loop',
    props: ['slides'],

    watch: {
      slides: function() {
        console.log('watch slides:'+this.slides)
        //this.swiper.slideTo(1, 1000, false)
      }
    },
  }
</script>

<style lang="scss" scoped>
  @import '@/components/variables.scss';
  @import '@/components/swiper.scss';

</style>
