<template>
  <div>
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
            <v-container>
              <v-row>
                <v-col cols="12" sm="6">
                  <v-text-field label="클래스 이름" required></v-text-field>
                </v-col>
                <v-col cols="12" sm="6">
                  <v-text-field
                    label="클래스 가격"
                    hint="ex) 50000원 -> 50000"
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
                    required
                  ></v-select>
                </v-col>
                <v-col cols="12" sm="3">
                  <v-select
                    :items="['상', '중', '하']"
                    label="난이도"
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
                  ><MakeClassCalendars></MakeClassCalendars
                ></v-col>
              </v-row>
            </v-container>
            <small>*indicates required field</small>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="blue darken-1" text @click="dialog = false">
              Close
            </v-btn>
            <v-btn color="blue darken-1" text @click="dialog = false">
              Save
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>
  </div>
</template>

<script>
import MakeClassCalendars from '@/components/stores/MakeClassCalendars.vue';
export default {
  components: {
    MakeClassCalendars,
  },
  data: () => ({
    dialog: false,
  }),
};
</script>

<style></style>
