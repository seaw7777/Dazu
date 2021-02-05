<template>
  <div>
    <v-sheet class="mx-auto" elevation="8" max-width="1000">
      <p>다가오는 클래스</p>
      <v-slide-group v-model="model" class="pa-4" center-active show-arrows>
        <v-slide-item v-for="n in classLen" :key="n" v-slot="{ active }">
          <v-card
            :color="active ? 'primary' : 'grey lighten-1'"
            class="ma-4"
            height="260"
            width="300"
            @click="classclick(n - 1)"
          >
            <v-img
              src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
              height="180px"
            ></v-img>
            <v-card-title>
              {{ classItems[n - 1].class_name }}
            </v-card-title>
          </v-card>
        </v-slide-item>
      </v-slide-group>
    </v-sheet>
  </div>
</template>

<script>
import { customerUpcomingClass } from '@/api/auth';
export default {
  data: () => ({
    model: null,
    classItems: [],
    checkClass: false,
    classLen: Number,
  }),
  async created() {
    this.isLoading = true;
    const classList = await customerUpcomingClass('1');
    this.isLoading = false;
    this.classItems = classList.data;
    this.classLen = classList.data.length;
    if (this.classLen > 0) {
      this.checkClass = true;
    }
    // console.log('받은거' + JSON.stringify(this.classItems));
  },
  methods: {
    classclick(n) {
      const id = this.classItems[n].classcode;
      this.$router.push(`/class/detail/${id}`);
    },
  },
};
</script>

<style></style>
