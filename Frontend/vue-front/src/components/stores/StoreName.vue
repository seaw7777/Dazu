<template>
  <div>
    <v-card width="600px">
      <v-card-title>가게 이름</v-card-title>
      <v-card-text>{{ this.storeData.store_name }}</v-card-text>
      <v-row justify="center">
        <v-dialog v-model="dialog" persistent max-width="290">
          <template v-slot:activator="{ on, attrs }">
            <v-btn
              color="primary"
              dark
              v-bind="attrs"
              v-on="on"
              @click="changeName(storeData)"
            >
              편집
            </v-btn>
          </template>
          <v-card>
            <v-card-title class="headline">
              가게 이름 편집
            </v-card-title>
            <v-card-text
              ><v-text-field
                v-model.trim="newStoreName"
                label="이름바꾸자"
                clearable
              ></v-text-field
            ></v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="green darken-1" text @click="putStoreName()">
                SAVE
              </v-btn>
              <v-btn color="green darken-1" text @click="dialog = false">
                CLOSE
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-row>
    </v-card>
  </div>
</template>

<script>
import { updateStoreName } from '@/api/store';
export default {
  data() {
    return {
      dialog: false,
      newStoreName: '',
      id: Number,
    };
  },
  props: {
    storeData: Object,
  },
  computed: {
    newName: function() {
      console.log(this.storeName);
      return this.newStoreName;
    },
  },
  methods: {
    changeName(data) {
      this.newStoreName = data.store_name;
    },
    changeDialog() {
      this.dialog = false;
    },
    async putStoreName() {
      this.id = this.storeData.storecode;
      await updateStoreName({
        dong: '',
        lat: '',
        lng: '',
        member_usercode: '',
        store_describe: '',
        store_grade: '',
        store_grade_cnt: '',
        store_location: '',
        store_name: this.newStoreName,
        storecode: this.id,
      });
      this.changeDialog();
      this.$router.go(this.$router.currentRoute);
    },
  },
};
</script>

<style></style>
