<template>
  <div>
    <!-- <div class="coming-container"><ComingClass></ComingClass></div> -->
    <v-row no-gutters>
      <v-col
        v-for="classItem in classItems"
        :key="classItem.classcode"
        cols="12"
        sm="4"
      >
        <ClassItem :classItem="classItem"></ClassItem></v-col
    ></v-row>
  </div>
</template>

<script>
import ClassItem from '@/components/classes/ClassItem.vue';
import { fetchClasses } from '@/api/classes';
export default {
  data() {
    return {
      isLoading: false,
      classItems: [],
      code: '',
      member: {},
      tab: null,
    };
  },
  components: {
    ClassItem,
    // ComingClass,
  },
  async created() {
    this.isLoading = true;
    const { data } = await fetchClasses(this.$store.state.dong);
    this.isLoading = false;
    console.log('클래스:' + data);
    this.classItems = data;
  },
};
</script>

<style scope>
.coming-container {
  display: flex;
  margin: 20px;
}
</style>
