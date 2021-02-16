<template>
  <div v-if="checkClass">
    <section class="related-products spad">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-center">
            <div class="section-title">
              <h2>Coming Up Classes</h2>
            </div>
          </div>
        </div>
        <v-slide-group v-model="model" class="pa-4" center-active show-arrows>
          <v-slide-item v-for="n in classLen" :key="n">
            <v-card class="ma-4" elevation="0" @click="classclick(n - 1)">
              <div class="product__item">
                <div class="product__item__pic set-bg" data-setbg="pic">
                  <img :src="pic" />
                  <div class="product__label">
                    <span>{{ classItems[n - 1].class_date }}</span>
                  </div>
                </div>
                <div class="product__item__text">
                  <h6>
                    <a href="#">{{ classItems[n - 1].class_name }}</a>
                  </h6>
                  <div class="product__item__price">
                    {{ classItems[n - 1].class_starttime }} -
                    {{ classItems[n - 1].class_endtime }}
                  </div>
                  <div class="cart_add">
                    <a href="#" @click="classclick">Go to Class</a>
                  </div>
                </div>
              </div>
            </v-card>
          </v-slide-item>
        </v-slide-group>
      </div>
    </section>
  </div>
</template>

<script>
import { customerUpcomingClass } from '@/api/auth';
import Pic from '@/assets/img/shop/product-3.jpg';
export default {
  data() {
    return {
      model: null,
      classItems: [],
      checkClass: false,
      classLen: Number,
      pic: Pic,
    };
  },
  async created() {
    this.isLoading = true;
    const id = this.$store.state.usercode;
    const { data } = await customerUpcomingClass(id);
    console.log('받은거' + JSON.stringify(data));
    this.isLoading = false;
    this.classItems = data;
    this.classLen = data.length;
    if (this.classLen > 0) {
      this.checkClass = true;
    }
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
