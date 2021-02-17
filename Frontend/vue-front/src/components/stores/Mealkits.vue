<template>
  <div>
    <div v-if="mealkit === ''">
      <v-row no-gutters>
        <v-dialog v-model="dialog" persistent max-width="800px">
          <template v-slot:activator="{ on, attrs }">
            <div class="my-2">
              <v-btn
                tile
                elevation="0"
                large
                style="display: inline-block;font-size: 14px;font-weight: 600;text-transform: uppercase;padding: 14px 30px;color: #ffffff;background: #f08632;letter-spacing: 2px;"
                depressed
                color="warning"
                v-bind="attrs"
                v-on="on"
              >
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
                      accept="image/jpeg"
                      truncate-length="15"
                      label="밀키트 썸네일 등록"
                      v-model="thumbnail"
                    ></v-file-input>
                  </v-col>
                  <v-col cols="12" sm="6">
                    <v-file-input
                      accept="image/jpeg"
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
              <v-btn color="blue darken-1" text @click="clickInsertMealkit">
                Save
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-row>
    </div>
    <div v-if="mealkit !== ''">
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
              <span class="headline">밀키트 관리(수정)</span>
            </v-card-title>
            <v-card-text>
              <h5>밀키트 정보</h5>
              <v-container>
                <v-row>
                  <v-col cols="12" sm="6">
                    <v-text-field
                      accept="image/jpeg"
                      label="밀키트 이름"
                      v-model="mealkit.mealkit_name"
                    ></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="6">
                    <v-text-field
                      label="밀키트 가격(원)"
                      hint="ex) 10000원 -> 10000"
                      v-model="mealkit.mealkit_price"
                    ></v-text-field>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col cols="12" sm="6">
                    <v-file-input
                      accept="image/jpeg"
                      truncate-length="15"
                      label="밀키트 썸네일 등록"
                      v-model="mealkit.mealkit_thumbnail"
                    ></v-file-input>
                  </v-col>
                  <v-col cols="12" sm="6">
                    <v-file-input
                      truncate-length="15"
                      label="밀키트 상세 설명 등록"
                      v-model="mealkit.mealkit_detail"
                    ></v-file-input>
                  </v-col>
                </v-row>
              </v-container>
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="red darken-1" text @click="clickDeleteMealkit">
                Delete
              </v-btn>
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
  </div>
</template>
<script>
import { postMealkits } from '@/api/mealkit';
import { updateMealkits } from '@/api/mealkit';
import { deleteMealkits } from '@/api/mealkit';
import { fetchMealkit } from '@/api/mealkit';
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
      thumbnail: null,
      detail: null,
      price: '',
      mealkit: '',
    };
  },
  async mounted() {},
  methods: {
    async clickUpdateMealkit() {
      var fd = new FormData();
      fd.append('files', this.mealkit_thumbnail);
      fd.append('files', this.mealkit_detail);
      var datadummy = {
        class_information_classcode: this.classcode,
        class_information_classname: '',
        mealkit_name: this.name,
        mealkit_price: this.price,
        mealkitcode: '',
      };
      fd.append(
        'key',
        new Blob([JSON.stringify(datadummy)], {
          type: 'application/json',
        }),
      );
      await updateMealkits(fd);
      this.dialog = false;
    },
    async clickDeleteMealkit() {
      await deleteMealkits(this.mealkit.mealkitcode);
      this.dialog = false;
    },
    async clickInsertMealkit() {
      console.log(this.classcode);
      var fd = new FormData();
      fd.append('files', this.thumbnail);
      fd.append('files', this.detail);
      var datadummy = {
        class_information_classcode: this.classcode,
        class_information_classname: '',
        mealkit_name: this.name,
        mealkit_price: this.price,
        mealkitcode: '',
      };
      fd.append(
        'key',
        new Blob([JSON.stringify(datadummy)], {
          type: 'application/json',
        }),
      );
      await postMealkits(fd);
      this.dialog = false;
    },
  },
  async created() {
    const id = this.classcode;
    const { data } = await fetchMealkit(id);
    console.log(JSON.stringify(data));
    this.mealkit = data;
  },
};
</script>
<style></style>
