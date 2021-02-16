<template>
  <div>
    <div class="blog__sidebar__item">
      <h5>MY Classes</h5>

      <div
        class="blog__sidebar__recent"
        v-for="item in classDataList"
        :key="item.name"
      >
        <router-link
          :to="'/class/detail/' + item.classcode"
          tag="a"
          class="blog__sidebar__recent__item"
        >
          <div class="blog__sidebar__recent__item__pic">
            <img src="img/blog/br-1.jpg" alt="" />
          </div>
          <div class="blog__sidebar__recent__item__text">
            <p>{{ item.class_name }}</p>
            <span>난이도 | {{ item.class_difficult }}</span>
            <br />
            <span>분류 | {{ item.food_type }}</span>
          </div>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
import { fetchStoreClassInfo } from '@/api/store';

export default {
  data() {
    return {
      classDataList: [],
    };
  },
  async created() {
    const storecode = this.$store.state.storecode;
    console.log(storecode);
    const res = await fetchStoreClassInfo(storecode);
    this.classDataList = res.data;
  },
};
</script>

<style></style>
