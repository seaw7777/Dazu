<template>
  <div>
    <v-data-table
      :headers="headers"
      :items="tipList"
      :items-per-page="5"
      class="table elevation-1"
      @click:row="handleClick"
      :search="search"
    >
      <template v-slot:top>
        <!-- <v-row>
          <v-col cols="12" sm="6">
            <v-text-field
              v-model="search"
              label="키워드를 검색해주세요."
              class="mx-4"
            ></v-text-field>
          </v-col> -->
        <div class="board-form">
          <v-text-field
            v-model="search"
            label="키워드를 검색해주세요."
            class="textarea mx-4"
            style="width:300px;"
          ></v-text-field>

          <!-- </v-row> -->
          <v-row>
            <v-dialog v-model="dialog" persistent max-width="600px">
              <template v-slot:activator="{ on, attrs }">
                <v-btn
                  class="writebtn primary-btn"
                  color="orange darken-3"
                  dark
                  v-bind="attrs"
                  v-on="on"
                >
                  나의 꿀팁 작성
                </v-btn>
              </template>
              <v-card>
                <v-card-title>
                  <h4 class="checkout__title">새로운 꿀팁 등록</h4>
                  <!-- <span class="headline">새로운 꿀팁 등록</span> -->
                </v-card-title>
                <v-card-text>
                  <v-container>
                    <v-row>
                      <v-col cols="12" sm="10">
                        <!-- <v-text-field
                          v-model="newTitle"
                          :rules="rules"
                          counter="25"
                          label="제목"
                        ></v-text-field> -->
                        <div class="checkout__input">
                          <p>제목<span>*</span></p>
                          <input
                            class="title-input"
                            maxlength="25"
                            type="text"
                            v-model="newTitle"
                          />
                          <p class="title-count">{{ newTitle.length }}/25</p>
                        </div>
                      </v-col>
                      <v-col cols="12" md="10">
                        <!-- <v-textarea
                          outlined
                          name="input-7-4"
                          label="내용을 입력하세요."
                          v-model="newContent"
                        ></v-textarea> -->
                        <div class="checkout__input">
                          <p>내용<span>*</span></p>
                          <textarea
                            type="text"
                            v-model="newContent"
                            placeholder="내용을 입력하세요."
                            class="content-input"
                          />
                        </div>
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
                  <v-btn color="blue darken-1" text @click="postNewTip()">
                    Save
                  </v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>
          </v-row>
        </div>
      </template>
    </v-data-table>
  </div>
</template>

<script>
import { getTipList, postTip } from '@/api/community';
// import TipCreate from '@/components/community/TipCreate.vue';
export default {
  components: {
    // TipCreate,
  },
  data() {
    return {
      search: '',
      dialog: false,
      newTitle: '',
      newContent: '',
      headers: [
        {
          text: 'No',
          align: 'center',
          sortable: false,
          value: 'board_code',
        },
        { text: '작성자', value: 'nickname', sortable: false, align: 'center' },
        {
          text: '제목',
          value: 'board_title',
          sortable: false,
          align: 'center',
        },
      ],
      tipList: [],
    };
  },
  async created() {
    const tipList = await getTipList('""');
    this.tipList = tipList.data;
  },
  computed: {
    isContentsValid() {
      return this.contents.length <= 200;
    },
  },
  methods: {
    handleClick(value) {
      this.titleClick(value);
    },
    titleClick(item) {
      const id = item.board_code;
      this.$router.push(`/community/tip/detail/${id}`);
    },
    changeDialog() {
      this.dialog = false;
    },
    async postNewTip() {
      await postTip({
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

<style scoped>
.table {
  width: 80%;
  margin-left: auto;
  margin-right: auto;
}
/* .v-data-table-header {
  font-size: 3rem;
} */
.board-form {
  display: grid;
  grid-template-areas: 'textarea writebtn';
  align-content: center;
  justify-content: end;
}
.textarea {
  grid-area: textarea;
}
.writebtn {
  grid-area: writebtn;
  margin-top: 30px;
  margin-left: 20px;
  margin-right: 20px;
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
