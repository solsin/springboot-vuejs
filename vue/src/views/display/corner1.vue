<template>
  <swiper ref="top" class="swiper" :options="entity.swiperOption">
    <template v-for="(slide) in slides">
      <swiper-slide :key="slide.id">
        <div class="slide-goods-item">
          <div v-if="slide.sourceType == 'image'" class="slide-goods-img">
            <img v-bind:data-src="slide.src" class="swiper-lazy" />
            <div class="swiper-lazy-preloader swiper-lazy-preloader-white"></div>
          </div>
          <div v-if="slide.sourceType == 'video'" class="video-js slide-goods-video">
            <video v-bind:src="slide.src" :options="entity.videoOption" />
          </div>
          <div class="slide-goods-info">
            <div class="goods-name">{{slide.text}}</div>
            <div class="goods-price">{{slide.price}}원</div>
          </div>

        </div>
      </swiper-slide>
    </template>
    <div class="swiper-pagination" slot="pagination"></div>
  </swiper>
</template>

<script>
  import { Swiper, SwiperSlide } from 'vue-awesome-swiper'
  import 'swiper/swiper-bundle.css'
  import videojs from 'video.js';
  import 'video.js/dist/video-js.css'
  
  export default {
    name: 'top-corner',
    title: 'Loop mode / Infinite loop',
    props: ['slides'],
    components: {
      Swiper,
      SwiperSlide
    },
    data() {
      return {
        entity: {
          slides: [],
          swiperOption: {
            init: false,
            slidesPerView: 1,
            spaceBetween: 30,
            loop: true,
            // Disable preloading of all images
            preloadImages: false,
            // Enable lazy loading
            lazy: {
              loadPrevNext: true,
              loadPrevNextAmount: 2,
            },
            pagination: {
              el: '.swiper-pagination',
              clickable: true
            }
          },
          videoOption: {
            autoplay: true,
            controls: true,
            crossOrigin: 'anonymous',
            width: 100,
          }
        }
      }
    },
    computed: {
      swiper() {
        return this.$refs.top.$swiper
      }
    },
    mounted() {
      console.log('Current Swiper instance object', this.swiper)
    },
    updated() {
      console.log('updated')
      // videojs init
      var videoEls = this.swiper.$el.find('video');
      videoEls.forEach(function(videoEl){
        let player = videojs(videoEl, this.videoOption);
        player.on('playerReady', function(){
          console.log('player ready')
        });
      });
    },
    // beforeDestroy() {
    //     if (this.player) {
    //         this.player.dispose()
    //     }
    // },
    watch: {
      slides: function() {
        console.log('watch slides:'+this.swiper.realIndex+', totalSize:'+this.slides.length+', slideIdx:'+this.slideIdx)

        this.swiper.lazy.load();
        this.swiper.on('init', function(swiper){
          swiper.slideToLoop(1, 1000, false)
        });
        this.swiper.on('slideChange', function (swiper) {
          // console.error(swiper)
          console.error(swiper.$el.find('video'));
          let lazyImgs = swiper.$el.find('.swiper-slide-duplicate').find('img');
          
          lazyImgs.forEach(function(lazyImg) {
            if (lazyImg != null) {
              // console.log(lazyImg.getAttribute('src'));
              if (!lazyImg.getAttribute('src')) {
                lazyImg.src = lazyImg.getAttribute('data-src')
                lazyImg.nextSibling.remove();
              }
            }
          });
        });

        // initialzie swiper
        this.swiper.init();
      }
    },
  }
</script>

<style lang="scss" scoped>
  @import '@/components/variables.scss';
  @import '@/components/swiper.scss';

  .slide-goods-item {
    position: relative;
  }
  //.slide-goods-img { width: 72px; }
  .slide-goods-img img { border-radius: 4px; }
  .slide-goods-info {
    font-size: 14px;
    top: 60px;
    left: 30px;
  }
</style>
