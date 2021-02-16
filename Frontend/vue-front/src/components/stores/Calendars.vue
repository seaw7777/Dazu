<template>
  <div>
    <v-row no-gutters>
      <v-dialog v-model="dialog" persistent max-width="800px">
        <template v-slot:activator="{ on, attrs }">
          <div class="my-2">
            <v-btn
              tile
              elevation="0"
              large
              style="font-size: 14px;color: #ffffff;background: #111111;font-weight: 600;border: none;text-transform: uppercase;display: inline-block;letter-spacing: 2px;padding: 14px 30px;"
              v-bind="attrs"
              v-on="on"
              ><v-icon left>
                mdi-calendar-edit
              </v-icon>
              스케줄 관리
            </v-btn>
          </div>
        </template>
        <v-card>
          <v-card-title>
            <span class="headline">클래스 스케줄 관리</span>
          </v-card-title>
          <v-card-text>
            <v-sheet height="64">
              <v-toolbar flat>
                <v-btn fab text small color="grey darken-2" @click="prev">
                  <v-icon small>
                    mdi-chevron-left
                  </v-icon>
                </v-btn>
                <v-btn fab text small color="grey darken-2" @click="next">
                  <v-icon small>
                    mdi-chevron-right
                  </v-icon>
                </v-btn>
                <v-toolbar-title v-if="$refs.calendar">
                  {{ $refs.calendar.title }}
                </v-toolbar-title>
                <v-spacer></v-spacer>
              </v-toolbar>
            </v-sheet>
            <v-sheet height="600">
              <v-calendar
                ref="calendar"
                v-model="focus"
                color="primary"
                :events="events"
                :event-color="getEventColor"
                :type="type"
                @click:event="showEvent"
                @click:more="viewDay"
                @click:date="viewDay"
              ></v-calendar>
              <v-menu
                v-model="selectedOpen"
                :close-on-content-click="false"
                :activator="selectedElement"
                offset-x
              >
                <v-card color="grey lighten-4" min-width="350px" flat>
                  <v-toolbar :color="selectedEvent.color" dark>
                    <UpdateClassCalendars
                      :selectedEvent="selectedEvent"
                    ></UpdateClassCalendars>
                    <v-btn
                      icon
                      @click="clickDeleteClassTime(selectedEvent.timecode)"
                      ><v-icon>mdi-trash-can</v-icon></v-btn
                    >
                    <v-toolbar-title
                      v-html="selectedEvent.name"
                    ></v-toolbar-title>
                    <v-spacer></v-spacer>
                    <v-btn icon>
                      <v-icon>mdi-dots-vertical</v-icon>
                    </v-btn>
                  </v-toolbar>
                  <v-card-text>
                    <span v-html="selectedEvent.describe"></span>
                  </v-card-text>
                  <v-card-text>
                    <span><strong>강의시간 : </strong></span>
                    <span v-html="selectedEvent.startTime"></span>
                    <span v-html="'-'"></span>
                    <span v-html="selectedEvent.endTime"></span>
                  </v-card-text>
                  <v-card-actions>
                    <v-btn text color="secondary" @click="selectedOpen = false">
                      Cancel
                    </v-btn>
                  </v-card-actions>
                </v-card>
              </v-menu>
            </v-sheet>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn text @click="dialog = false">
              닫기
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
      <v-dialog v-model="dialog2" persistent max-width="600px">
        <v-card>
          <v-card-title>
            <span class="headline">강의 등록</span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-row>
                <v-col cols="12" sm="6">
                  <v-icon>mdi-calendar-check</v-icon>
                  <p>날짜</p>
                  <v-text-field
                    persistent-hint
                    required
                    v-model="focus"
                    readonly
                  ></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-icon>mdi-pencil</v-icon>
                  <v-textarea
                    label="상세 정보를 입력해주세요."
                    v-model="describe"
                  ></v-textarea>
                </v-col>
                <v-col cols="12" sm="6">
                  <v-select
                    v-model="startTime"
                    :items="[
                      '09:00:00',
                      '09:30:00',
                      '10:00:00',
                      '10:30:00',
                      '11:00:00',
                      '11:30:00',
                      '12:00:00',
                      '12:30:00',
                      '13:00:00',
                      '13:30:00',
                      '14:00:00',
                      '14:30:00',
                      '15:00:00',
                      '15:30:00',
                      '16:00:00',
                      '16:30:00',
                      '17:00:00',
                      '17:30:00',
                      '18:00:00',
                      '18:30:00',
                      '19:00:00',
                      '19:30:00',
                      '20:00:00',
                      '20:30:00',
                    ]"
                    required
                    ><template slot="label">
                      <v-icon>mdi-timer-outline</v-icon>
                      시작시간
                    </template>
                  </v-select>
                </v-col>
                <v-col cols="12" sm="6">
                  <v-select
                    v-model="endTime"
                    :items="[
                      '09:00:00',
                      '09:30:00',
                      '10:00:00',
                      '10:30:00',
                      '11:00:00',
                      '11:30:00',
                      '12:00:00',
                      '12:30:00',
                      '13:00:00',
                      '13:30:00',
                      '14:00:00',
                      '14:30:00',
                      '15:00:00',
                      '15:30:00',
                      '16:00:00',
                      '16:30:00',
                      '17:00:00',
                      '17:30:00',
                      '18:00:00',
                      '18:30:00',
                      '19:00:00',
                      '19:30:00',
                      '20:00:00',
                      '20:30:00',
                    ]"
                    required
                    ><template slot="label">
                      <v-icon>mdi-timer-outline</v-icon>
                      종료시간
                    </template>
                  </v-select>
                </v-col>
              </v-row>
            </v-container>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="blue darken-1" text @click="dialog2 = false">
              닫기
            </v-btn>
            <v-btn color="blue darken-1" text @click="clickInsertClassTime">
              저장
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>
  </div>
</template>
<script>
import { postClassTime } from '@/api/classes';
import { fetchClassTime } from '@/api/classes';
import { deleteClassTime } from '@/api/classes';
import UpdateClassCalendars from '@/components/stores/UpdateClassCalendars.vue';
export default {
  props: {
    classcode: {
      type: String,
      required: true,
    },
    class_name: {
      type: String,
      required: true,
    },
  },
  components: {
    UpdateClassCalendars,
  },
  data() {
    return {
      dialog: false,
      dialog2: false,
      focus: '',
      type: 'month',
      typeToLabel: {
        month: 'Month',
        week: 'Week',
        day: 'Day',
        '4day': '4 Days',
      },
      selectedEvent: {},
      selectedElement: null,
      selectedOpen: false,
      events: [],
      colors: [
        'blue',
        'indigo',
        'deep-purple',
        'cyan',
        'green',
        'orange',
        'grey darken-1',
      ],
      names: [this.class_name],
      startTime: '',
      endTime: '',
      describe: '',
    };
  },
  async mounted() {
    const { data } = await fetchClassTime(this.classcode);
    const events = [];
    for (let index = 0; index < data.length; index++) {
      const start = new Date(
        data[index].class_date + 'T' + data[index].class_starttime,
      );
      const end = new Date(
        data[index].class_date + 'T' + data[index].class_endtime,
      );

      events.push({
        name: this.names[this.rnd(0, this.names.length - 1)],
        startTime: data[index].class_starttime,
        endTime: data[index].class_endtime,
        start: start,
        end: end,
        color: this.colors[this.rnd(0, this.colors.length - 1)],
        timed: false,
        describe: data[index].class_describe,
        timecode: data[index].class_timecode,
        date: data[index].class_date,
      });
    }
    this.events = events;
  },
  methods: {
    async clickDeleteClassTime(timecode) {
      console.log(timecode);
      await deleteClassTime(timecode);
      this.dialog2 = false;
      this.dialog = false;
    },
    async clickInsertClassTime() {
      await postClassTime({
        class_date: this.focus,
        class_describe: this.describe,
        class_endtime: this.endTime,
        class_information_classcode: this.classcode,
        class_starttime: this.startTime,
        class_timecode: 0,
      });
      this.dialog2 = false;

      this.events.push({
        name: this.class_name,
        start: this.startTime,
        end: this.endTime,
        color: this.colors[this.rnd(0, this.colors.length - 1)],
        timed: false,
      });
    },
    viewDay({ date }) {
      this.focus = date;
      this.dialog2 = !this.dialog2;
    },
    getEventColor(event) {
      return event.color;
    },
    setToday() {
      this.focus = '';
    },
    prev() {
      this.$refs.calendar.prev();
    },
    next() {
      this.$refs.calendar.next();
    },
    showEvent({ nativeEvent, event }) {
      const open = () => {
        this.selectedEvent = event;
        this.selectedElement = nativeEvent.target;
        setTimeout(() => {
          this.selectedOpen = true;
        }, 10);
      };

      if (this.selectedOpen) {
        this.selectedOpen = false;
        setTimeout(open, 10);
      } else {
        open();
      }

      nativeEvent.stopPropagation();
    },
    rnd(a, b) {
      return Math.floor((b - a + 1) * Math.random()) + a;
    },
  },
};
</script>
<style></style>
