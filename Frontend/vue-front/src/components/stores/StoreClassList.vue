<template>
  <div>
    <v-card color="grey lighten-3" width="450px">
      <v-row>
        <v-col cols="8">
          <v-card-title>개설 클래스 목록</v-card-title>
        </v-col>
        <v-col cols="4">
          <MakeClass></MakeClass>
        </v-col>
      </v-row>
    </v-card>
  </div>
</template>

<script>
import MakeClass from '@/components/stores/MakeClass.vue';
export default {
  components: {
    MakeClass,
  },
  data() {
    return {};
  },
};
</script>

<style></style>
