<template>
  <div>
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
      classItems: [],
    };
  },
  components: {
    ClassItem,
  },
  async created() {
    const { data } = await fetchClasses('우이동');
    // console.log('클래스:' + JSON.stringify(data));
    this.classItems = data;
  },
};
</script>
<style scope></style>
