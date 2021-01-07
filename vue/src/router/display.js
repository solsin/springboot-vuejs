import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/",
      component: () => import("@/views/display/index"),
      children: [
        {
          path: "",
          name: "home",
          component: () => import("@/views/display/index")
        },
      ]
    },
    {
      name: "productDetail",
      path: "/goods",
      component: () => import("@/views/goods/index")
    },
    {
      name: "Category",
      path: "/category",
      component: () => import("@/views/category/index")
    },
  ]
});
