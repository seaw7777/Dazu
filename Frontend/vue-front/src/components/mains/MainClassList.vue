<template>
  <div>
    <section class="shop spad">
      <div class="container">
        <div class="row">
          <div
            class="col-lg-3 col-md-6 col-sm-6"
            v-for="classItem in classItems"
            :key="classItem.classcode"
          >
            <ClassItem :classItem="classItem"></ClassItem>
          </div>
        </div>
      </div>
    </section>
    <!-- <v-row no-gutters>
      <v-col
        v-for="classItem in classItems"
        :key="classItem.classcode"
        cols="12"
        sm="4"
      >
        <ClassItem :classItem="classItem"></ClassItem></v-col
    ></v-row> -->
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
    const userdong = this.$store.state.dong;
    const { data } = await fetchClasses(userdong);
    // console.log('클래스:' + JSON.stringify(data));
    this.classItems = data;
  },
};
</script>
<style scope>
.container {
  padding: 0.5rem;
  margin-left: auto;
  margin-right: auto;
}
</style>
