<template>
  <div>
    <v-card>
      <v-tabs v-model="tab" background-color="primary" dark>
        <v-tab
          v-for="item in items"
          :key="item.tab"
          @click="fetchData(item.tab)"
        >
          {{ item.tab }}
        </v-tab>
      </v-tabs>

      <v-tabs-items v-model="tab">
        <v-tab-item v-for="item in items" :key="item.tab">
          <v-card flat v-if="item.tab === 'MAP'">
            <v-card-text>
              <MainMap :houseItem="houseItem"></MainMap>
            </v-card-text>
          </v-card>
          <v-card flat v-else-if="item.tab === 'CLASS'">
            <ul>
              <v-card-text
                ><MainClassItem
                  v-for="classItem in classItems"
                  :key="classItem.classcode"
                  :classItem="classItem"
                ></MainClassItem
              ></v-card-text>
            </ul>
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
import { fetchStore } from '@/api/store';
import { customerGetInfoAPI } from '@/api/auth';

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
      storeItems: [],
      houseItem: {},
    };
  },
  components: {
    MainMap,
    MainClassItem,
  },
  methods: {
    async fetchData(tab) {
      if (tab === 'MAP') {
        const storeData = await fetchStore('우이동');
        const houseData = await customerGetInfoAPI('1');

        console.log(storeData);
        // console.log(JSON.stringify(houseData.data));

        this.storeItems = storeData.data;
        this.houseItem = houseData.data;
        console.log(this.storeItems);
      } else {
        this.isLoading = true;
        const { data } = await fetchClass('우이동');
        this.isLoading = false;
        console.log(data);
        this.classItems = data;
      }
    },
  },
};
</script>

<style></style>
