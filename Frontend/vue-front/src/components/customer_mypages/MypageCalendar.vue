<template>
  <div>
    <!-- {{ tmpcom }} -->
    <vc-calendar v-model="date" :attributes="attributes">
      <div slot="day-popover" slot-scope="{ dayTitle, attributes }">
        <div class="text-xs text-gray-300 font-semibold text-center">
          {{ dayTitle }}
        </div>
        <ul>
          <li v-for="{ key, customData } in attributes" :key="key">
            {{ customData.class_name }}
            {{ customData.class_starttime.slice(0, 5) }}
          </li>
        </ul>
      </div>
    </vc-calendar>
  </div>
</template>

<script>
import { MypageCustomerClass } from '@/api/mypage';

export default {
  data() {
    return {
      classDataList: [],
      date: new Date(),
    };
  },
  computed: {
    attributes() {
      return [
        // Attributes for todos
        ...this.classDataList.map(todo => ({
          dates: new Date(
            parseInt(todo.class_date.slice(0, 4)),
            parseInt(todo.class_date.slice(5, 7)) - 1,
            parseInt(todo.class_date.slice(8, 10)),
          ),
          dot: {
            color: 'orange',
            class: 'opacity-75',
          },
          popover: {
            slot: 'day-popover',
            label: todo.class_name,
          },
          customData: todo,
        })),
      ];
    },
    // tmpcomp() {
    //   const Classes = this.classDataList;
    //   return console.log(parseInt(Classes[0].class_date.slice((0, 4)) - 1));
    // },
  },
  methods: {
    movedetail() {
      // this.$router.push(`/class/detail/${classcode}`);
      console.log('click');
    },
  },
  async created() {
    const userid = this.$store.state.usercode;
    console.log(userid);
    const res = await MypageCustomerClass(userid);
    this.classDataList = res.data;
  },
};
</script>

<style></style>
