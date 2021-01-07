<template>
  <nav class="navbar navbar-light">
    <div class="container">
      <router-link class="navbar-brand" :to="{ name: 'home' }">
        home
      </router-link>
    </div>
  </nav>
</template>

<script>

export default {
  name: "Header",
};
</script>
