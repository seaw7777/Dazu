<template>
  <div>
    <v-row no-gutters>
      <v-col
        v-for="mealkitItem in mealkitItems"
        :key="mealkitItem.mealkitcode"
        cols="12"
        sm="4"
      >
        <MealkitItem :mealkitItem="mealkitItem"></MealkitItem></v-col
    ></v-row>
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
