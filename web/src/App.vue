<template>
  <a-layout>

      <the-header></the-header>

      <router-view/>

      <the-footer></the-footer>

  </a-layout>
</template>

<script lang="ts">
    import { defineComponent } from 'vue';
    // 引入自定义组件
    import TheHeader from '@/components/the-header.vue';
    import TheFooter from '@/components/the-footer.vue';

    // 使用自定义组件
    export default defineComponent({
        name: 'app',
        components: {
            TheHeader,
            TheFooter,
        },
    });
</script>

<style>
#components-layout-demo-top-side-2 .logo {
  width: 120px;
  height: 31px;
  background: rgba(255, 255, 255, 0.2);
  margin: 16px 28px 16px 0;
  float: left;
}
</style>
