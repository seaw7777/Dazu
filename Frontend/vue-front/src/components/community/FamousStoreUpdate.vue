<template>
  <div v-if="this.userId === this.$store.state.usercode">
    <v-row justify="center">
      <v-dialog v-model="dialog" persistent max-width="600px">
        <template v-slot:activator="{ on, attrs }">
          <v-btn color="primary" dark v-bind="attrs" v-on="on">
            수정
          </v-btn>
        </template>
        <v-card>
          <v-card-title>
            <span class="headline">나의 맛집 정보 수정</span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-row>
                <v-col cols="12" sm="10">
                  <v-text-field
                    v-model="updateTitle"
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
                    v-model="updateContent"
                  ></v-textarea>
                </v-col>
              </v-row>
            </v-container>
            <small>*indicates required field </small>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="blue darken-1" text @click="dialog = false">
              Close
            </v-btn>
            <v-btn color="blue darken-1" text @click="putChangeFamousStore()">
              Save
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>
  </div>
  <div v-else></div>
</template>

<script>
import { updateFamousStore } from '@/api/community';
import { putFamousStore } from '@/api/community';
export default {
  data: () => ({
    dialog: false,
    famousStoreList: [],
    updateTitle: '',
    updateContent: '',
    userId: Number,
  }),
  props: {
    boardId: Object,
  },
  async created() {
    const famousStoreData = await updateFamousStore(this.boardId);
    this.famousStoreList = famousStoreData.data;
    this.updateTitle = famousStoreData.data.board_title;
    this.updateContent = famousStoreData.data.board_contents;
    this.userId = famousStoreData.data.member_usercode;
  },
  methods: {
    changeDialog() {
      this.dialog = false;
    },
    async putChangeFamousStore() {
      await putFamousStore({
        board_code: this.boardId,
        board_contents: this.updateContent,
        board_good: '',
        board_title: this.updateTitle,
        board_visit: '',
        board_write_datetime: '',
        member_usercode: '',
        nickname: '',
      });
      this.changeDialog();
      this.$router.go(this.$router.currentRoute);
    },
  },
};
</script>

<style></style>
