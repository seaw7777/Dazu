<template>
  <div>
    <v-row no-gutters>
      <v-dialog v-model="dialog" persistent max-width="800px">
        <template v-slot:activator="{ on, attrs }">
          <div class="my-2">
            <v-btn icon v-bind="attrs" v-on="on">
              <v-icon>mdi-pencil</v-icon>
            </v-btn>
          </div>
        </template>
        <v-card>
          <v-card-title>
            <span class="headline">강의 수정</span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-row>
                <v-col cols="12" sm="6">
                  <v-icon>mdi-calendar-check</v-icon>
                  <a>날짜</a>
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
                <v-col cols="12">
                  <v-icon>mdi-file-find</v-icon>
                  <v-text-field
                    label="개설된 클래스 URL을 입력해주세요."
                    v-model="url"
                  ></v-text-field>
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
            <v-btn color="blue darken-1" text @click="dialog = false">
              닫기
            </v-btn>
            <v-btn color="blue darken-1" text @click="clickUpdateClassTime">
              저장
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>
  </div>
</template>
<script>
import { updateClassTime } from '@/api/classes';
export default {
  props: {
    selectedEvent: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      dialog: false,
      describe: this.selectedEvent.describe,
      startTime: this.selectedEvent.startTime,
      endTime: this.selectedEvent.endTime,
      focus: this.selectedEvent.date,
      url: '',
    };
  },
  methods: {
    async clickUpdateClassTime() {
      console.log(this.selectedEvent.timecode);
      console.log(this.startTime);
      await updateClassTime({
        class_date: '',
        class_describe: this.describe,
        class_endtime: this.endTime,
        class_information_classcode: 0,
        class_starttime: this.startTime,
        class_timecode: this.selectedEvent.timecode,
        class_url: this.url,
      });
      this.dialog = false;
    },
  },
};
</script>
<style></style>
