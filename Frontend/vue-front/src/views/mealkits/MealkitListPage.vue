<template>
  <div>
    <!-- Breadcrumb Begin -->
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
    <!-- Breadcrumb End -->
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
    <!-- <v-row no-gutters>
      <v-col
        v-for="mealkitItem in mealkitItems"
        :key="mealkitItem.mealkitcode"
        cols="12"
        sm="4"
      >
        <MealkitItem :mealkitItem="mealkitItem"></MealkitItem></v-col
    ></v-row> -->
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
    const dong = this.$store.state.dong;
    console.log(dong);
    const { data } = await fetchMealkits(dong);
    this.mealkitItems = data;
  },
};
</script>
<style scope></style>
