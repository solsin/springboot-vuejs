<!--
swiper-container class로 직접 Swiper instance를 생성하는건 browser에서 direct로 사용할 때는 됐는데, vue compile 모드에선 정상적으로 안됨.
아무래도 compile mode용 소스의 차이 같음.
-->
<template>
  <div class="swiper-container swipe-corner3">
    <ul class="swiper-wrapper">
        <li class="swiper-slide" v-for="(slide) in slides" :key="slide.id">
          <!-- cart-disable-mask disable / cart-disable-mask 구분 -->
          <div class="cart-disable-mask" :class="{'disable' : slide.salesCode == 'TMPR_SLDOUT'}">
            <a :href="'/nc/detail/detailPage?godNo='+slide.id">
              <div class="prdt-item-copy">
                <template v-if="slide.headText != null">{{conttText.dspCnrContt.conttNm}}<br></template>
              </div>
              <div class="prdt-item">
                <div class="label-area">
                  <i class="label-soldout" v-if="slide.salesCode == 'TMPR_SLDOUT'">일시품절</i>
                </div>
                <!-- Label case -->
                <div class="prdt-thumb">
                  <img class="thumb-type1" v-lazy="slide.imageSrc" data-width="280" data-height="240"/>
                </div>
                <!-- info -->
                <div class="prdt-info">
                  <dl>
                    <!--Head Copy는 어드민 별도 등록. -->
                    <dt class="prdt-head-copy">{{ slide.text }}</dt>
                    <dd class="prdt-price-serving">
                      <span class="prdt-price"><em>{{slide.price}}</em>원</span>
                    </dd>
                  </dl>
                </div>
              </div>
            </a>
          </div>
        </li>
      <!-- Add Pagination -->
      <div class="pagination-wrap">
          <span class="swiper-pagination-bar">
              <span class="swiper-pagination-fill"></span>
          </span>
          <span class="swiper-pagination-num">
              <span class="current-num"></span> / <span class="total-num"></span>
          </span>
      </div>
    </ul>
  </div>
</template>

<script>
  import {Swiper} from 'swiper'
  import 'swiper/swiper-bundle.css'

  export default {
    name: 'corner3',
    /* ${template} */
    props: ['slides'],
    components: {
        //'btn-add-cart': BtnAddCart()
    },
    data() {
      return {
        swiper: {},
      }
    },
    mounted: function() {
      var centerCustomSlide = new Swiper('.swipe-corner3', {
        init: true,
        centeredSlides: true,
        slidesPerView: 'auto',
        spaceBetween: 30
        // on: {
        //   slideChange: function () {
        //     var currentNum = document.querySelector('.swipe-corner3 .pagination-wrap .current-num');
        //     var totalNum = document.querySelector('.swipe-corner3 .pagination-wrap .total-num');
        //     var barSelector = document.querySelector('.swipe-corner3 .pagination-wrap .swiper-pagination-bar .swiper-pagination-fill');
        //     currentNum.innerHTML = String(centerCustomSlide.activeIndex + 1);
        //     totalNum.innerHTML = String(centerCustomSlide.slides.length);
        //     barSelector.style.width = (100 / centerCustomSlide.slides.length) * (centerCustomSlide.activeIndex + 1) + "%";
        //   },
        // }
      });

      // centerCustomSlide.on('init', function () {
      //   var currentNum = document.querySelector('.swipe-corner3 .current-num');
      //   var totalNum = document.querySelector('.swipe-corner3 .total-num');
      //   var barSelector = document.querySelector('.swipe-corner3 .swiper-pagination-fill');
      //   currentNum.innerHTML = String(centerCustomSlide.activeIndex + 1);
      //   totalNum.innerHTML = String(centerCustomSlide.slides.length);
      //   barSelector.style.width = (100 / centerCustomSlide.slides.length) * (centerCustomSlide.activeIndex + 1) + "%";
      // });

      this.swiper = centerCustomSlide
    },
    methods: {
    },
    watch: {
      slides: function() {
        this.swiper.init();
        console.log('inited')
        this.swiper.update();
      }
    }
  }
</script>

<style>
.swipe-corner3 { position: relative; overflow: hidden; width: 300px; height: 260px;}

.swipe-corner3 .swiper-slide { width: 81.111111%; padding: 0 6px; }

.swipe-corner3 a { display: block; }

.swipe-corner3 .label-area { left: 12px; }

.swipe-corner3 .prdt-item { position: relative; }

.swipe-corner3 .prdt-item-copy { text-align: center; font-size: 24px; line-height: 34px; color: #000; margin-bottom: 18px; font-family: 'NotoSerif',serif; font-weight: 300; }

.swipe-corner3 .prdt-thumb { border-radius: 4px; overflow: hidden; }

.swipe-corner3 .prdt-info { height: 68px; padding: 10px 0 14px; }

.swipe-corner3 .prdt-head-copy { font-weight: 400; font-size: 16px; line-height: 26px; letter-spacing: -0.8px; color: #000; white-space: nowrap; overflow: hidden; text-overflow: ellipsis; }

.swipe-corner3 .prdt-price-serving .prdt-price { display: inline-block; font-size: 14px; line-height: 26px; color: #000; font-weight: 700; }

.swipe-corner3 .prdt-price-serving .prdt-price em { letter-spacing: 0; font-size: 17px; line-height: 24px; color: #000; font-family: "Roboto", sans-serif; font-weight: 700; margin-right: 2px; }

.swipe-corner3 .prdt-price-serving .prdt-serving { display: inline-block; font-size: 14px; line-height: 24px; margin-left: 10px; }

.swipe-corner3 .prdt-price-serving .prdt-serving * { vertical-align: top; margin-top: 2px; margin-right: 2px; }

.swipe-corner3 .button-cart-wrap { position: absolute; right: 32px; bottom: 65px; /*transform: scale(1.222222222222222);box-shadow: 0 4px 6px 0 rgba(0, 0, 0, 0.1);*/ }

.swipe-corner3 .pagination-wrap { display: flex; padding: 0 10.2%; font-size: 0; }

.swipe-corner3 .pagination-wrap .swiper-pagination-bar { display: inline-block; font-size: 0; background-color: #eee; height: 1px; margin-top: 10px; }

.swipe-corner3 .pagination-wrap > * { flex: 1 1 auto; }

.swipe-corner3 .pagination-wrap .swiper-pagination-bar .swiper-pagination-fill { height: 1px; background-color: #000; width: 0%; display: inline-block; transition: 0.2s; }

.swipe-corner3 .pagination-wrap .swiper-pagination-num { font-size: 14px; line-height: 22px; text-align: right; white-space: nowrap; flex: 0 0 0px; padding-left: 14px; font-family: 'NotoSerif'; color: #ccc; font-weight: 400; }

.swipe-corner3 .pagination-wrap .swiper-pagination-num .current-num { color: #000; font-weight: 700; }

.swipe-corner3 .pagination-wrap .swiper-pagination-num .total-num { font-weight: 400; color: #ccc; }

.swipe-corner3 .cart-disable-mask.disable a { opacity: 1; }
</style>
