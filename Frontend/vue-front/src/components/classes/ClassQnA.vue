<template>
  <div>
    <v-container>
      <v-row no-gutters>
        <v-text-field :rules="rules" v-model="insertData"></v-text-field>
        <v-btn large color="primary" dark @click="insertQna">
          등록
        </v-btn>
        <br /><br />
        <v-card class="mx-auto" width="1000">
          <v-list>
            <v-list-item>
              <v-list-item-title><strong>답변상태</strong></v-list-item-title>
              <v-list-item-title><strong>내용</strong></v-list-item-title>
              <v-list-item-title><strong>작성자</strong></v-list-item-title>
              <v-list-item-title><strong>작성일</strong></v-list-item-title>
            </v-list-item>

            <v-list-group v-for="(qna, i) in qnas" :key="i">
              <template v-slot:activator>
                <v-list-item-title
                  v-if="qna.class_qna_answer_write_content !== null"
                  >답변완료</v-list-item-title
                >
                <v-list-item-title
                  v-if="qna.class_qna_answer_write_content === null"
                  >답변대기</v-list-item-title
                >
                <v-list-item-title>{{
                  qna.class_qna_board_write_contents
                }}</v-list-item-title>
                <v-list-item-subtitle>{{
                  qna.member_nickname
                }}</v-list-item-subtitle>
                <v-list-item-subtitle>{{
                  qna.class_qna_baoard_write_datetime
                }}</v-list-item-subtitle>
              </template>
              <div v-if="qna.class_qna_answer_write_content !== null">
                <v-list-item v-if="usertype === '0'">
                  <v-list-item-title
                    ><v-text-field v-model="insertAnswerData"></v-text-field
                  ></v-list-item-title>
                  <v-list-item-subtitle
                    ><v-btn
                      medium
                      color="primary"
                      dark
                      @click="insertAnswer(qna.class_qna_board_code)"
                    >
                      수정
                    </v-btn></v-list-item-subtitle
                  >
                </v-list-item>
                <v-list-item v-else-if="usertype === '1'">
                  <v-list-item-icon>
                    <v-icon>mdi-check-circle</v-icon>
                  </v-list-item-icon>
                  <v-list-item-title>{{
                    qna.class_qna_answer_write_content
                  }}</v-list-item-title>
                </v-list-item>
              </div>
              <div v-else-if="qna.class_qna_answer_write_content === null">
                <v-list-item v-if="usertype === '0'">
                  <v-list-item-title
                    ><v-text-field v-model="insertAnswerData"></v-text-field
                  ></v-list-item-title>
                  <v-list-item-subtitle
                    ><v-btn
                      medium
                      color="primary"
                      dark
                      @click="insertAnswer(qna.class_qna_board_code)"
                    >
                      등록
                    </v-btn></v-list-item-subtitle
                  >
                </v-list-item>
              </div>
            </v-list-group>
          </v-list>
        </v-card>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import { fetchClassQnA } from '@/api/classes';
import { postQnA } from '@/api/classes';
import { postQnAAnswer } from '@/api/classes';
export default {
  data() {
    return {
      insertData: '',
      insertAnswerData: '',
      usertype: '0',
      qnas: [],
    };
  },
  async created() {
    const id = this.$route.params.id;
    // this.usertype = this.$store.state.usertype;
    // console.log(this.usertype);
    console.log(id);
    const { data } = await fetchClassQnA(id);
    this.qnas = data;
    console.log(data);
  },
  methods: {
    async insertQna() {
      console.log(this.$route.params.id);
      console.log(this.insertData);
      console.log(this.$store.state.usercode);
      try {
        await postQnA({
          class_information_classcode: this.$route.params.id,
          class_qna_answer_write_content: '',
          class_qna_board_write_datetime: '',
          class_qna_board_code: '',
          class_qna_board_write_contents: this.insertData,
          member_nickname: '',
          member_usercode: this.$store.state.usercode,
        });
      } catch (error) {
        console.log(error);
      }
    },
    async insertAnswer(code) {
      console.log(code);
      try {
        await postQnAAnswer({
          class_information_classcode: '',
          class_qna_answer_write_content: this.insertAnswerData,
          class_qna_board_write_datetime: '',
          class_qna_board_code: code,
          class_qna_board_write_contents: '',
          member_nickname: '',
          member_usercode: '',
        });
      } catch (error) {
        console.log(error);
      }
    },
  },
};
</script>

<style></style>
