<template>
  <div v-if="this.userId === this.$store.state.usercode">
    <v-row>
      <v-dialog v-model="dialog" persistent max-width="600px">
        <template v-slot:activator="{ on, attrs }">
          <v-btn class="editbtn" color="orange" dark v-bind="attrs" v-on="on">
            수정
          </v-btn>
        </template>
        <v-card>
          <v-card-title>
            <span class="headline">나의 꿀팁 수정</span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-row>
                <v-col cols="12" sm="10">
                  <div class="checkout__input">
                    <p>제목<span>*</span></p>
                    <input
                      class="title-input"
                      type="text"
                      maxlength="25"
                      v-model="updateTitle"
                      @click="titleclick"
                    />
                  </div>
                  <p class="title-count">{{ updateTitle.length }}/25</p>
                </v-col>
                <v-col cols="12" md="10">
                  <!-- <v-textarea
                    outlined
                    name="input-7-4"
                    label="내용을 입력하세요."
                    v-model="updateContent"
                  ></v-textarea> -->
                  <div class="checkout__input">
                    <p>내용<span>*</span></p>
                    <textarea
                      type="text"
                      v-model="updateContent"
                      placeholder="내용을 입력하세요."
                      class="content-input"
                      @click="contentclick"
                    />
                  </div>
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
            <v-btn color="blue darken-1" text @click="putChangeTip()">
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
import { updateTip } from '@/api/community';
import { putTip } from '@/api/community';
export default {
  data: () => ({
    dialog: false,
    tipList: [],
    updateTitle: '',
    updateContent: '',
    userId: Number,
  }),
  props: {
    boardId: Object,
  },
  async created() {
    const tipData = await updateTip(this.boardId);
    this.tipList = tipData.data;
    this.updateTitle = tipData.data.board_title;
    this.updateContent = tipData.data.board_contents;
    this.userId = tipData.data.member_usercode;
  },
  methods: {
    titleclick() {
      this.updateTitle = '';
    },
    contentclick() {
      this.updateContent = '';
    },
    changeDialog() {
      this.dialog = false;
    },
    async putChangeTip() {
      await putTip({
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

<style scoped>
.editbtn {
  margin-bottom: 12px;
}
.title-input {
  width: 100%;
}
.content-input {
  height: 200px;
  width: 100%;
  padding: 20px;
  font-size: 14px;
  border-style: solid;
  border-color: rgb(204, 201, 201);
}
.title-count {
  display: flex;
  justify-content: flex-end;
}
</style>
