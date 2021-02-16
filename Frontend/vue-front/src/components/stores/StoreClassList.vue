<template>
  <div class="wishlist__cart__table">
    <table>
      <thead>
        <tr>
          <th>Class</th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <tr
          v-for="classSimpleItem in classSimpleItems"
          :key="classSimpleItem.classcode"
        >
          <ClassSimpleItem :classSimpleItem="classSimpleItem"></ClassSimpleItem>
        </tr>
      </tbody>
    </table>
    <MakeClass :storecode="storecode"></MakeClass>
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
    const id = this.$store.state.storecode;
    this.storecode = id;
    const { data } = await fetchStoreClass(id);
    console.log(data);
    this.classSimpleItems = data;
  },
};
</script>

<style></style>
