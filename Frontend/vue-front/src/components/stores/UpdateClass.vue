<template>
  <div>
    <v-row no-gutters>
      <v-dialog v-model="dialog" persistent max-width="800px">
        <template v-slot:activator="{ on, attrs }">
          <v-icon v-bind="attrs" v-on="on">mdi-lead-pencil</v-icon>
        </template>
        <v-card>
          <v-card-title>
            <span class="headline">클래스 정보 수정</span>
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
                    truncate-length="15"
                    label="클래스 썸네일 등록"
                  ></v-file-input>
                </v-col>
                <v-col cols="12" sm="6">
                  <v-file-input
                    truncate-length="15"
                    label="클래스 상세 설명 등록"
                  ></v-file-input>
                </v-col>
                <v-col cols="12"
                  ><UpdateClassCalendars
                    :classcode="classSimpleItem.classcode"
                  ></UpdateClassCalendars
                ></v-col>
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
              <v-row>
                <v-col cols="12" sm="6">
                  <v-text-field
                    label="밀키트 가격"
                    hint="ex) 10000원 -> 10000"
                  ></v-text-field>
                </v-col>
                <v-col cols="12" sm="6">
                  <v-file-input
                    truncate-length="15"
                    label="밀키트 상세 설명 등록"
                  ></v-file-input>
                </v-col>
              </v-row>
            </v-container>
            <small>*indicates required field</small>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="blue darken-1" text @click="dialog = false">
              Close
            </v-btn>
            <v-btn color="blue darken-1" text @click="clickUpdateClass">
              Save
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>
  </div>
</template>

<script>
import UpdateClassCalendars from '@/components/stores/MakeClassCalendars.vue';
import { updateClass } from '@/api/classes';
export default {
  components: {
    UpdateClassCalendars,
  },
  props: {
    classSimpleItem: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      dialog: false,
      class_name: this.classSimpleItem.class_name,
      class_price: this.classSimpleItem.class_price,
      class_time: this.classSimpleItem.class_time,
      class_difficult: this.classSimpleItem.class_difficult,
      food_type: this.classSimpleItem.food_type,
      mealkit_ok: this.classSimpleItem.mealkit_ok,
    };
  },
  methods: {
    async clickUpdateClass() {
      await updateClass({
        class_describe: '',
        class_difficult: this.class_difficult,
        class_name: this.class_name,
        class_price: this.class_price,
        class_time: this.class_time,
        classcode: this.classcode,
        food_type: this.food_type,
        mealkit_ok: this.mealkit_ok,
        store_information_store_describe: '',
        store_information_store_name: '',
        store_information_storecode: '',
      });
    },
  },
};
</script>

<style></style>
