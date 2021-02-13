<template>
  <div>
    <v-row no-gutters>
      <v-dialog v-model="dialog" persistent max-width="800px">
        <template v-slot:activator="{ on, attrs }">
          <div class="my-2">
            <v-btn depressed color="warning" v-bind="attrs" v-on="on">
              <v-icon left>
                mdi-food-variant
              </v-icon>
              밀키트 관리
            </v-btn>
          </div>
        </template>
        <v-card>
          <v-card-title>
            <span class="headline">밀키트 관리(등록)</span>
          </v-card-title>
          <v-card-text>
            <h5>밀키트 정보</h5>
            <v-container>
              <v-row>
                <v-col cols="12" sm="6">
                  <v-text-field
                    label="밀키트 이름"
                    v-model="name"
                  ></v-text-field>
                </v-col>
                <v-col cols="12" sm="6">
                  <v-text-field
                    label="밀키트 가격(원)"
                    hint="ex) 10000원 -> 10000"
                    v-model="price"
                  ></v-text-field>
                </v-col>
              </v-row>
              <v-row>
                <v-col cols="12" sm="6">
                  <v-file-input
                    truncate-length="15"
                    label="밀키트 썸네일 등록"
                    v-model="thumbnail"
                  ></v-file-input>
                </v-col>
                <v-col cols="12" sm="6">
                  <v-file-input
                    truncate-length="15"
                    label="밀키트 상세 설명 등록"
                    v-model="detail"
                  ></v-file-input>
                </v-col>
              </v-row>
            </v-container>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="blue darken-1" text @click="dialog = false">
              Close
            </v-btn>
            <v-btn color="blue darken-1" text @click="clickUpdateMealkit">
              Save
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>
  </div>
</template>
<script>
import { postMealkits } from '@/api/mealkit';
export default {
  props: {
    classcode: {
      type: String,
      required: true,
    },
  },
  data() {
    return {
      dialog: false,
      mealkit_ok: '',
      name: '',
      thumbnail: '',
      detail: '',
      price: '',
    };
  },
  async mounted() {},
  methods: {
    async clickUpdateMealkit() {
      console.log(this.classcode);
      await postMealkits({
        class_information_classcode: this.classcode,
        class_information_classname: '',
        mealkit_detail: this.detail,
        mealkit_name: this.name,
        mealkit_price: this.price,
        mealkit_thumbnail: this.thumbnail,
        mealkitcode: '',
      });
      this.dialog = false;
    },
  },
};
</script>
<style></style>
