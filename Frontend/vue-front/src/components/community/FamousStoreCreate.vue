<template>
  <div>
    <v-row justify="center">
      <v-dialog v-model="dialog" persistent max-width="600px">
        <template v-slot:activator="{ on, attrs }">
          <v-btn color="primary" dark v-bind="attrs" v-on="on">
            나의 맛집 정보 작성
          </v-btn>
        </template>
        <v-card>
          <v-card-title>
            <span class="headline">새로운 맛집 정보 등록</span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-row>
                <v-col cols="12" sm="10">
                  <v-text-field
                    v-model="newTitle"
                    :rules="rules"
                    counter="25"
                    label="제목"
                  ></v-text-field>
                </v-col>
                <v-col cols="12" md="10">
                  <v-textarea
                    outlined
                    name="input-7-4"
                    label="내용을 입력하세요."
                    v-model="newContent"
                  ></v-textarea>
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
            <v-btn color="blue darken-1" text @click="postNewFamousStore()">
              Save
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>
  </div>
</template>

<script>
import { postFamousStore } from '@/api/community';
export default {
  data: () => ({
    dialog: false,
    newTitle: '',
    newContent: '',
  }),
  methods: {
    changeDialog() {
      this.dialog = false;
    },
    async postNewFamousStore() {
      await postFamousStore({
        board_code: '',
        board_contents: this.newContent,
        board_good: '',
        board_title: this.newTitle,
        board_visit: '',
        board_write_datetime: '',
        member_usercode: this.$store.state.usercode,
        nickname: this.$store.state.username,
      });
      this.changeDialog();
      this.$router.go(this.$router.currentRoute);
    },
  },
};
</script>

<style></style>
