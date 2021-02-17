<template>
  <div>
    <div class="breadcrumb-option">
      <div class="container">
        <div class="row">
          <div class="col-lg-6 col-md-6 col-sm-6">
            <div class="breadcrumb__text">
              <h2>Class</h2>
            </div>
          </div>
        </div>
      </div>
    </div>
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
    if (!this.$store.getters.isLogin) {
      console.log('goto loginBtn');
      this.$router.push('/user');
    } else {
      this.$store.state.header = '1';
    }
    this.isLoading = true;
    console.log(this.$store.state.dong);
    const { data } = await fetchClasses(this.$store.state.dong);
    this.isLoading = false;
    console.log('클래스:' + data);
    this.classItems = data;
  },
};
</script>

<style>
/* .coming-container {
  display: flex;
  margin: 20px;
} */
</style>
