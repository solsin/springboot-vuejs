<template>
  <div>
    <swiper ref="corner2" class="swiper" :options="entity.swiperOption" @slideChange="onSlideChange">
      <template v-for="(slide) in slides">
        <swiper-slide :key="slide.id">
          <div class="slide-goods-item">
            <div class="slide-goods-img">
              <img v-lazy="slide.src" />
            </div>
            <div class="slide-goods-info">
              <div class="goods-name">{{slide.text}}</div>
              <div class="goods-price">{{slide.price}}원</div>
            </div>
          </div>
        </swiper-slide>
      </template>
      <div class="swiper-pagination s01" slot="pagination"></div>
    </swiper>
  </div>
</template>

<script>
  import { Swiper, SwiperSlide } from 'vue-awesome-swiper'
  import 'swiper/swiper-bundle.css'

  export default {
    name: 'corner2',
    title: 'Loop mode / Infinite loop',
    props: ['slides'],
    components: {
      Swiper,
      SwiperSlide
    },
    data() {
      return {
        entity: {
          swiperOption: {
            initialSlide: 0,
            slidesPerView: 1,
            spaceBetween: 30,
            pagination: {
              el: '.swiper-pagination.s01',
              type: 'fraction',
            }
          }
        },
        slideIdx: 1,
        totalSlide: 1,
      }
    },
    computed: {
      swiper() {
        return this.$refs.corner2.$swiper
      }
    },
    mounted() {
      console.log('Current Swiper instance object', this.swiper)
      this.swiper.init();
    },
    methods: {
      onSlideChange() {
        this.slideIdx = this.swiper.realIndex+1
        console.log('current idx:'+this.swiper.realIndex)
      },
    },
    watch: {
      slides: function() {
        console.log('watch slides:'+this.swiper.realIndex+', totalSize:'+this.slides.length+', slideIdx:'+this.slideIdx)
        this.swiper.slideTo(1, 1000, false)
      }
    },
  }
</script>

<style lang="scss" scoped>
  @import '@/components/variables.scss';
  @import '@/components/swiper.scss';

  .swiper-pagination::before {
    content: "";
    display: inline-block;
    width: 40px;
    height: 1px;
    background-color: #000;
    vertical-align: middle;
    margin-right: 10px;
  }
</style>
