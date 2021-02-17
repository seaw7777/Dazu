<template>
  <div>
    <div class="breadcrumb-option">
      <div class="container">
        <div class="row">
          <div class="col-lg-6 col-md-6 col-sm-6">
            <div class="breadcrumb__text">
              <h2>Mealkit</h2>
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
            v-for="mealkitItem in mealkitItems"
            :key="mealkitItem.mealkitcode"
          >
            <MealkitItem :mealkitItem="mealkitItem"></MealkitItem>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>
<script>
import MealkitItem from '@/components/mealkits/MealkitItem.vue';
import { fetchMealkits } from '@/api/mealkit';
export default {
  data() {
    return {
      mealkitItems: [],
    };
  },
  components: {
    MealkitItem,
  },
  async created() {
    if (!this.$store.getters.isLogin) {
      console.log('goto loginBtn');
      this.$router.push('/user');
    } else {
      this.$store.state.header = '1';
    }
    const dong = this.$store.state.dong;
    console.log(dong);
    const { data } = await fetchMealkits(dong);
    this.mealkitItems = data;
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
