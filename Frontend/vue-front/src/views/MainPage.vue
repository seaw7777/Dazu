<template>
  <div>
    <div><ComingClass></ComingClass></div>

    <v-card>
      <v-tabs
        v-model="tab"
        background-color="deep-purple accent-4"
        centered
        dark
        icons-and-text
      >
        <v-tab v-for="item in items" :key="item.tab">
          {{ item.tab }}
          <v-icon>{{ item.icon }}</v-icon>
        </v-tab>
      </v-tabs>

      <v-tabs-items v-model="tab">
        <v-tab-item v-for="item in items" :key="item.tab">
          <v-card flat v-if="item.tab === '지도'">
            <v-card-text class="card-container"
              ><MainMap></MainMap
            ></v-card-text>
          </v-card>
          <v-card flat v-else-if="item.tab === '목록'">
            <v-card-text class="card-container"
              ><MainClassList></MainClassList>
            </v-card-text>
          </v-card>
        </v-tab-item>
      </v-tabs-items>
    </v-card>

    <div class="map-container" id="map" style="width:900px;height:500px;"></div>
  </div>
</template>

<script>
import ComingClass from '@/components/classes/ComingClass.vue';
import MainMap from '@/components/mains/MainMap.vue';
import MainClassList from '@/components/mains/MainClassList.vue';
export default {
  data() {
    return {
      isLoading: false,
      tab: null,
      items: [
        {
          tab: '지도',
          icon: 'mdi-home-map-marker',
        },
        {
          tab: '목록',
          icon: 'mdi-heart',
        },
      ],
    };
  },
  components: {
    ComingClass,
    MainClassList,
    MainMap,
  },
};
</script>

<style scoped>
.map-container {
  display: flex;
  justify-content: center;
  margin-top: 50px;
}
</style>
