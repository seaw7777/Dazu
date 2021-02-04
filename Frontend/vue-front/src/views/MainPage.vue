<template>
  <div>
    <MainMap></MainMap>
  </div>
</template>

<script>
import MainMap from '@/components/mains/MainMap.vue';

// import { fetchClasses } from '@/api/classes';
export default {
  data() {
    return {
      isLoading: false,
      classItems: [],
      code: '',
      member: {},
      tab: null,
      items: [
        { tab: 'MAP', content: 'Tab 1 Content' },
        { tab: 'CLASS', content: 'Tab 2 Content' },
      ],
    };
  },
  computed: {
    classList() {
      return this.classItems;
    },
  },
  created() {
    this.code = this.$store.state.code;
    // console.log(this.member);
  },
  components: {
    MainMap,
    // MainClassItem,
  },
};
</script>

<style></style>
