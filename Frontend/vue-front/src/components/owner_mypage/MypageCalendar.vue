<template>
  <div>
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
import { fetchStoreClassInfo } from '@/api/store';
import { fetchClassTime } from '@/api/classes';

export default {
  data() {
    return {
      classDataList: [],
      classCodeList: [],
      classTimeList: [],
      date: new Date(),
    };
  },
  computed: {
    attributes() {
      return [
        // Attributes for todos
        ...this.classTimeList.map(todo => ({
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
    const res = await fetchStoreClassInfo(userid);
    this.classDataList = res.data;
    // console.log(this.classDataList);
    for (var key in this.classDataList) {
      var code = this.classDataList[key].classcode;
      this.classCodeList.push(code);
    }
    // console.log(this.classCodeList);
    for (var idx in this.classCodeList) {
      var classcode = this.classCodeList[idx];
      var time = await fetchClassTime(classcode);
      // console.log(time.data);
      var timeData = time.data;
      for (var index in timeData) {
        var value = timeData[index];
        // console.log(value);
        this.classTimeList.push(value);
      }
    }
    // console.log(this.classTimeList);
  },
};
</script>

<style></style>
