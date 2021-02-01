<template>
  <div>
    <v-card>
      <v-tabs v-model="tab" background-color="primary" dark>
        <v-tab v-for="item in items" :key="item.tab">
          {{ item.tab }}
        </v-tab>
      </v-tabs>

      <v-tabs-items v-model="tab">
        <v-tab-item v-for="item in items" :key="item.tab">
          <v-card flat v-if="item.tab === 'MAP'">
            <v-card-text><MainMap></MainMap></v-card-text>
          </v-card>
          <v-card flat v-else-if="item.tab === 'CLASS'">
            <v-card-text><MainClassItem></MainClassItem></v-card-text>
          </v-card>
        </v-tab-item>
      </v-tabs-items>
    </v-card>
  </div>
</template>

<script>
import MainMap from '@/components/mains/MainMap.vue';
import MainClassItem from '@/components/mains/MainClassItem.vue';
export default {
  data() {
    return {
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
    console.log(this.member);
  },
  components: {
    MainMap,
    MainClassItem,
  },
};
</script>

<style></style>
