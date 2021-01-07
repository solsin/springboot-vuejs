# springboot-vuejs front shop demo application

> springboot, thymeleaf, vuejs를 기반으로 SPA/MPA hybrid application을 위한 demo이다.

## thymeleaf/vuejs hybrid
일반적인 springboot vuejs hybrid는 vuejs dev tool은 nodejs를 front server로 개발을 진행하고, build를 실행하여 springboot의 static page에 html을 생성하고, 이후 thymeleaf template에 적용하도록 한다.
이 demo에서는 개발의 편의성을 위해 thymeleaf templage을 master page로 정의하고, 필요한 nodejs의 리소스들은 zuul proxy를 통해 연계하도록 하여 개발의 편의성을 높이고자 한다. 

## SPA/MPA hybrid
1. 전시 : 전시메인, 카테고리 목록, 상품상세
2. 주문 : 장바구니, 주문, 주문완료
3. 마이페이지 : 고객정보, 주문내역 

## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Lints and fixes files
```
npm run lint
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).
