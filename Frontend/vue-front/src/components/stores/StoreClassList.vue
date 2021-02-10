<template>
  <div>
    <v-card color="grey lighten-3" width="450px">
      <v-row>
        <v-col cols="8">
          <v-card-title>개설 클래스 목록</v-card-title>
        </v-col>
        <v-col cols="4">
          <MakeClass :storecode="storecode"></MakeClass>
        </v-col>
      </v-row>
      <v-col
        v-for="classSimpleItem in classSimpleItems"
        :key="classSimpleItem.classcode"
        cols="12"
        sm="12"
      >
        <ClassSimpleItem :classSimpleItem="classSimpleItem"></ClassSimpleItem
      ></v-col>
    </v-card>
  </div>
</template>

<script>
import MakeClass from '@/components/stores/MakeClass.vue';
import ClassSimpleItem from '@/components/classes/ClassSimpleItem.vue';
import { fetchStoreClass } from '@/api/classes';
export default {
  components: {
    MakeClass,
    ClassSimpleItem,
  },
  data() {
    return {
      classSimpleItems: [],
      storecode: '',
    };
  },
  async created() {
    const id = this.$route.params.storecode;
    this.storecode = id;
    const { data } = await fetchStoreClass('1');
    console.log(data);
    this.classSimpleItems = data;
  },
};
</script>

<style></style>
