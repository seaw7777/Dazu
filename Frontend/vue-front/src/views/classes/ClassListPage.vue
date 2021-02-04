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
      isLoading: false,
      classItems: [],
      code: '',
      member: {},
      tab: null,
    };
  },
  components: {
    ClassItem,
  },
  async created() {
    this.isLoading = true;
    const { data } = await fetchClasses('우이동');
    this.isLoading = false;
    console.log(data);
    this.classItems = data;
  },
};
</script>

<style></style>
