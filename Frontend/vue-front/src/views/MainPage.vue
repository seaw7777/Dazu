<template>
  <div>
    <v-card>
      <v-tabs v-model="tab" background-color="primary" dark>
        <v-tab v-for="item in items" :key="item.tab" @click="fetchData">
          {{ item.tab }}
        </v-tab>
      </v-tabs>

      <v-tabs-items v-model="tab">
        <v-tab-item v-for="item in items" :key="item.tab">
          <v-card flat v-if="item.tab === 'MAP'">
            <v-card-text><MainMap></MainMap></v-card-text>
          </v-card>
          <v-card flat v-else-if="item.tab === 'CLASS'">
            <v-row no-gutters>
              <v-col
                v-for="classItem in classItems"
                :key="classItem.classcode"
                cols="12"
                sm="4"
              >
                <v-card-text>
                  <MainClassItem
                    :classItem="classItem"
                  ></MainClassItem></v-card-text></v-col
            ></v-row>
          </v-card>
        </v-tab-item>
      </v-tabs-items>
    </v-card>
  </div>
</template>

<script>
import MainMap from '@/components/mains/MainMap.vue';
import MainClassItem from '@/components/mains/MainClassItem.vue';

import { fetchClass } from '@/api/classes';
export default {
  data() {
    return {
      isLoading: false,
      classItems: [],
      code: '',
      member: {},
      tab: null,
      items: [
        { tab: 'MAP', content: 'Tab 1 Content' },
        { tab: 'CLASS', content: 'Tab 2 Content' },
      ],
    };
  },
  created() {
    this.code = this.$store.state.code;
    // console.log(this.member);
  },
  components: {
    MainMap,
    MainClassItem,
  },
  methods: {
    async fetchData() {
      this.isLoading = true;
      const { data } = await fetchClass('우이동');
      this.isLoading = false;
      console.log(data);
      this.classItems = data;
    },
  },
};
</script>

<style></style>
