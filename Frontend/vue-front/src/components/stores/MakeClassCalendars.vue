<template>
  <div>
    <v-row>
      <v-col cols="12" sm="6">
        <v-date-picker v-model="dates" multiple></v-date-picker>
      </v-col>
      <v-col cols="12" sm="6">
        <v-menu
          ref="menu"
          v-model="menu"
          :close-on-content-click="false"
          :return-value.sync="dates"
          transition="scale-transition"
          offset-y
          min-width="auto"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-combobox
              v-model="dates"
              multiple
              chips
              small-chips
              label="Multiple picker in menu"
              prepend-icon="mdi-calendar"
              readonly
              v-bind="attrs"
              v-on="on"
            ></v-combobox>
          </template>
          <v-date-picker v-model="dates" multiple no-title scrollable>
            <v-spacer></v-spacer>
            <v-btn text color="primary" @click="menu = false">
              Cancel
            </v-btn>
            <v-btn text color="primary" @click="$refs.menu.save(dates)">
              OK
            </v-btn>
          </v-date-picker>
        </v-menu>
      </v-col>
      <v-col cols="12">
        <v-autocomplete
          :items="[
            '9:00',
            '9:30',
            '10:00',
            '10:30',
            '11:00',
            '11:30',
            '12:00',
            '12:30',
            '13:00',
            '13:30',
            '14:00',
            '14:30',
            '15:00',
            '15:30',
            '16:00',
            '16:30',
            '17:00',
            '17:30',
            '18:00',
            '18:30',
            '19:00',
            '19:30',
            '20:00',
            '20:30',
          ]"
          label="클래스 개설 시간"
          v-model="times"
          multiple
        ></v-autocomplete>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import { fetchClassTime } from '@/api/classes';
export default {
  data: function() {
    return {
      dates: [],
      menu: false,
      times: [],
    };
  },
  props: {
    classcode: {
      type: String,
      required: true,
    },
  },
  async created() {
    console.log(this.classcode);
    const { data } = await fetchClassTime(this.classcode);
    for (let index = 0; index < data.length; index++) {
      console.log(data[index].date);
      this.dates.push(data[index].date);
      this.time.push(data[index].starttime);
    }
    console.log(JSON.stringify(data));
  },
};
</script>

<style></style>
