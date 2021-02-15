<template>
  <div>
    <div>
      <ComingClass></ComingClass>
    </div>

    <div>
      <v-card elevation="0">
        <v-tabs
          class="tabs"
          v-model="tab"
          centered
          icons-and-text
          color="orange accent-4"
        >
          <v-tab class="tab" v-for="item in items" :key="item.tab">
            <!-- {{ item.tab }}
            <v-icon>{{ item.icon }}</v-icon> -->
            <!-- <div class="categories__item"> -->
            <!-- <div class="categories__item__icon"> -->
            <!-- <span :class="item.icon"></span> -->
            {{ item.tab }}
            <v-icon>{{ item.icon }}</v-icon>
            <!-- </div>
            </div> -->
          </v-tab>
        </v-tabs>

        <section class="testimonial spad">
          <div class="container">
            <div class="row">
              <div class="col-lg-12 text-center">
                <div class="section-title">
                  <h2>Our Neighborhood</h2>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-lg-12 text-center">
                <div class="section-title">
                  <v-tabs-items v-model="tab">
                    <v-tab-item v-for="item in items" :key="item.tab">
                      <div flat v-if="item.tab === '지도'">
                        <MainMap></MainMap>
                      </div>
                      <div flat v-else-if="item.tab === '목록'">
                        <MainClassList></MainClassList>
                      </div>
                    </v-tab-item>
                  </v-tabs-items>
                </div>
              </div>
            </div>
          </div>
        </section>
      </v-card>
    </div>
  </div>
</template>

<script>
import '@/assets/css/style.css';

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
.flaticon-034-chocolate-roll {
  /* width: 1rem; */
  size: 80%;
}

.tabs {
  height: 110px;
}
.tab {
  height: 100%;
}
.categories__item__icon {
  font-size: 1px;
}
</style>
