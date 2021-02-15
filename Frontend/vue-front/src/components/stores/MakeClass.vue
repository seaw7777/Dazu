<template>
  <div class="mt-7">
    <v-row justify="center">
      <v-dialog v-model="dialog" persistent max-width="800px">
        <template v-slot:activator="{ on, attrs }">
          <v-btn color="primary" dark v-bind="attrs" v-on="on">
            클래스 추가
          </v-btn>
        </template>
        <v-card>
          <v-card-title>
            <span class="headline">새로운 클래스 생성</span>
          </v-card-title>
          <v-card-text>
            <h5>클래스 정보</h5>
            <v-container>
              <v-row>
                <v-col cols="12" sm="6">
                  <v-text-field
                    label="클래스 이름"
                    v-model="class_name"
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="12" sm="6">
                  <v-text-field
                    label="클래스 가격"
                    hint="ex) 50000원 -> 50000"
                    v-model="class_price"
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="12" sm="3">
                  <v-select
                    :items="['1', '2', '3', '4', '5']"
                    label="최대 수강 인원"
                    v-model="class_max"
                    required
                  ></v-select>
                </v-col>
                <v-col cols="12" sm="3">
                  <v-select
                    :items="['1시간', '1시간 30분', '2시간']"
                    label="클래스 총 시간"
                    v-model="class_time"
                    required
                  ></v-select>
                </v-col>
                <v-col cols="12" sm="3">
                  <v-select
                    :items="['상', '중', '하']"
                    label="난이도"
                    v-model="class_difficult"
                    required
                  ></v-select>
                </v-col>
                <v-col cols="12" sm="3">
                  <v-select
                    :items="[
                      '한식',
                      '중식',
                      '일식',
                      '분식',
                      '양식',
                      '야식',
                      '카페/디저트',
                      '기타',
                    ]"
                    label="음식 분류"
                    v-model="food_type"
                    required
                  ></v-select>
                </v-col>
                <v-col cols="12" sm="6">
                  <v-file-input
                    v-model="class_Thumbnail"
                    truncate-length="15"
                    label="클래스 썸네일 등록"
                  ></v-file-input>
                </v-col>
                <v-col cols="12" sm="6">
                  <v-file-input
                    v-model="class_intro"
                    truncate-length="15"
                    label="클래스 상세 설명 등록"
                  ></v-file-input>
                </v-col>
              </v-row>
            </v-container>
            <v-container>
              <h5>밀키트 정보</h5>
              <v-row>
                <v-col cols="6">
                  <v-select
                    :items="['제공', '미제공']"
                    label="밀키트 제공 여부"
                    v-model="mealkit_ok"
                  ></v-select>
                </v-col>
              </v-row>
            </v-container>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="blue darken-1" text @click="dialog = false">
              Close
            </v-btn>
            <v-btn color="blue darken-1" text @click="clickInsertClass">
              Save
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>
  </div>
</template>

<script>
import { postClass } from '@/api/classes';
export default {
  props: {
    storecode: {
      type: String,
      required: true,
    },
  },
  data() {
    return {
      dialog: false,
      class_name: '',
      class_price: '',
      class_max: '',
      class_time: '',
      class_difficult: '',
      food_type: '',
      dates: [],
      times: [],
      mealkit_ok: '',
      class_Thumbnail: '',
      class_intro: '',
    };
  },
  methods: {
    async clickInsertClass() {
      if (this.class_time === '1시간') this.class_time = '01:00:00';
      else if (this.class_time === '1시간 30분') this.class_time = '01:30:00';
      else if (this.class_time === '2시간') this.class_time = '02:00:00';
      var fd = new FormData();
      fd.append('files', this.class_Thumbnail);
      fd.append('files', this.class_intro);
      var datadummy = {
        class_describe: '',
        class_difficult: this.class_difficult,
        class_name: this.class_name,
        class_price: this.class_price,
        class_time: this.class_time,
        classcode: '',
        food_type: this.food_type,
        mealkit_ok: this.mealkit_ok,
        store_information_store_describe: '',
        store_information_store_name: '',
        store_information_storecode: this.storecode,
        class_max: this.class_max,
      };

      fd.append(
        'key',
        new Blob([JSON.stringify(datadummy)], {
          type: 'application/json',
        }),
      );
      await postClass(fd);
      this.dialog = false;
      this.$router.go(this.$router.currentRoute);
    },
  },
};
</script>

<style></style>
