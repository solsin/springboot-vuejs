<template>
  <div id="app">
    <TheHeader />
    <router-view></router-view>
    <TheFooter />
  </div>
</template>

<script>
import TheHeader from "@/components/header";
import TheFooter from "@/components/footer";

export default {
  name: "App",
  components: {
    TheHeader,
    TheFooter
  }
};
</script>

<style></style>
