<template>
  <div>
    <v-container>
      <v-row no-gutters>
        <v-text-field :rules="rules" v-model="insertData"></v-text-field>
        <v-btn large color="primary" dark @click="insertQna">
          등록
        </v-btn>
        <br /><br />
        <v-card class="mx-auto" width="1500">
          <v-list>
            <v-list-item>
              <v-list-item-title><strong>내용</strong></v-list-item-title>
              <v-list-item-subtitle
                ><strong>작성자</strong></v-list-item-subtitle
              >
              <v-list-item-subtitle>작성일</v-list-item-subtitle>
            </v-list-item>

            <v-list-group v-for="(qna, i) in qnas" :key="i">
              <template v-slot:activator>
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

              <v-list-item>
                <v-list-item-icon>
                  <v-icon>mdi-check-circle</v-icon>
                </v-list-item-icon>
                <v-list-item-title>{{
                  qna.class_qna_answer_write_content
                }}</v-list-item-title>
                <v-list-item-subtitle
                  ><v-text-field></v-text-field
                ></v-list-item-subtitle>
                <v-list-item-subtitle
                  ><v-btn medium color="primary" dark @click="insertQna">
                    등록
                  </v-btn></v-list-item-subtitle
                >
              </v-list-item>
            </v-list-group>
          </v-list>
        </v-card>
      </v-row>
    </v-container>
  </div>
</template>

<script>
// import { fetchClassQnA } from '@/api/classes';
import { postQnA } from '@/api/classes';
export default {
  data() {
    return {
      insertData: '',
      qnas: [
        {
          class_qna_baoard_write_datetime: '2021-02-05',
          class_qna_board_write_contents: '이거 왜이래요?',
          class_qna_answer_write_content: '원래 그래요^^',
          member_nickname: 'dd',
        },
        {
          class_qna_baoard_write_datetime: '2021-02-05',
          class_qna_board_write_contents: '이거 왜이래요?',
          class_qna_answer_write_content: '원래 그래요^^',
          member_nickname: 'ddd',
        },
        {
          class_qna_baoard_write_datetime: '2021-02-05',
          class_qna_board_write_contents: '이거 왜이래요?',
          class_qna_answer_write_content: '원래 그래요^^',
          member_nickname: 'dddd',
        },
      ],
    };
  },
  async created() {
    const id = this.$route.params.id;
    console.log(id);
    // const { data } = await fetchClassQnA(id);
    // this.qnas = data;
    // console.log(data);
  },
  methods: {
    async insertQna() {
      console.log(this.$route.params.id);
      console.log(this.insertData);
      console.log(this.$store.state.usercode);
      try {
        await postQnA({
          class_information_classcode: this.$route.params.id,
          class_qna_answer_write_content: this.insertData,
          class_qna_baoard_write_datetime: '',
          class_qna_board_code: '',
          class_qna_board_write_contents: '',
          member_nickname: '',
          member_usercode: this.$store.state.usercode,
        });
      } catch (error) {
        console.log(error);
      }
    },
  },
};
</script>

<style></style>
