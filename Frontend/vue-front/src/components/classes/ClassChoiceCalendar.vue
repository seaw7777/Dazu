<template>
  <div>
    <vc-date-picker :attributes="attributes" is-dark v-model="date">
      <div slot="day-popover" slot-scope="{ dayTitle, attributes }">
        <div class="text-xs text-gray-300 font-semibold text-center">
          {{ dayTitle }}
        </div>
        <ul>
          <li v-for="{ key, customData } in attributes" :key="key">
            {{ customData.class_timecode }}
            {{ customData.class_starttime.slice(0, 5) }}
          </li>
        </ul>
      </div>
    </vc-date-picker>
    <v-col cols="12">
      <v-select
        :items="classTimeList"
        label="시간 선택"
        dense
        solo
        v-model="timecode"
      ></v-select>
    </v-col>

    <div>
      <div v-if="mealkitchoice == '밀키트 포함'">
        <v-card class="mx-auto" max-width="300">
          <v-card-text>
            <p class="display-1 text--primary">
              ₩ {{ classData.class_price + classData.milkit_price }}
            </p>
          </v-card-text>
        </v-card>
      </div>
      <div v-else-if="mealkitchoice === 'Only 밀키트'">
        <v-card class="mx-auto" max-width="300">
          <v-card-text>
            <p class="display-1 text--primary">
              ₩ {{ classData.milkit_price }}
            </p>
          </v-card-text>
        </v-card>
      </div>
      <div v-else>
        <v-card class="mx-auto" max-width="300">
          <v-card-text>
            <p class="display-1 text--primary">₩ {{ classData.class_price }}</p>
          </v-card-text>
        </v-card>
      </div>
      <div>
        <v-btn class="submit" elevation="2" @click="submitTime">신청하기</v-btn>
      </div>
    </div>
  </div>
</template>

<script>
import { fetchClassTime, postClassTime } from '@/api/classes';
// postClassTime

export default {
  props: {
    mealkitchoice: {
      type: String,
    },
    classData: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      date: new Date(),
      classDataList: [],
      classTimeList: [],
      timecode: '',
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
            label: todo.class_starttime.slice(0, 5) + todo.class_timecode,
            visibility: 'focus',
            positionFixed: true,
          },
          customData: todo,
        })),
      ];
    },
  },
  methods: {
    async submitTime() {
      const Tcode = this.timecode.slice(0, 2);
      console.log(Tcode);
      const id = this.$route.params.id;
      console.log(id);
      const res = await postClassTime({
        class_information_classcode: id,
        class_time_information_class_timecode: Tcode,
        member_usercode: this.$store.state.usercode,
      });
      console.log(res);
    },
  },

  async created() {
    const id = this.$route.params.id;
    console.log(id);
    const res = await fetchClassTime(id);
    this.classDataList = res.data;
    console.log(this.classDataList);
    for (var key in res.data) {
      const value =
        res.data[key].class_timecode +
        ' ' +
        res.data[key].class_date.slice(0, 4) +
        '-' +
        res.data[key].class_date.slice(5, 7) +
        '-' +
        res.data[key].class_date.slice(8, 10) +
        ' ' +
        res.data[key].class_starttime.slice(0, 5);
      this.classTimeList.push(value);
    }
  },
};
</script>

<style scoped>
.submit {
  margin-top: 10px;
}
</style>
