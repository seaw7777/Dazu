<template>
  <div>
    <section class="blog-details spad">
      <div class="container">
        <div class="row d-flex justify-content-center">
          <div class="col-lg-8">
            <div class="blog__details__content">
              <div class="blog__details__comment">
                <h5>Q&A</h5>
                <v-text-field
                  :rules="rules"
                  v-model="insertData"
                ></v-text-field>
                <button class="primary-btn" @click="insertQna">질문등록</button>
                <div v-for="(qna, i) in qnas" :key="i">
                  <div class="blog__details__comment__item">
                    <div class="blog__details__comment__item__pic">
                      <img :src="qna.image_url" alt="" />
                    </div>
                    <div class="blog__details__comment__item__text">
                      <h6>{{ qna.member_nickname }}</h6>
                      <span>{{ qna.class_qna_baoard_write_datetime }}</span>
                      <span style="width: 500px;">
                        {{ qna.class_qna_board_write_contents }}
                      </span>
                      <div class="blog__details__comment__btns">
                        <a
                          v-if="
                            qna.class_qna_answer_write_content !== null &&
                              qna.answer_usercode !== user
                          "
                          @click="answer_check = '1'"
                          >답변완료</a
                        >
                        <a v-if="qna.class_qna_answer_write_content === null"
                          >답변대기</a
                        >
                        <a
                          v-if="qna.answer_usercode === user"
                          @click="write_check = '1'"
                          >답변작성</a
                        >
                      </div>
                    </div>
                  </div>
                  <div
                    class="blog__details__comment__item blog__details__comment__item--reply"
                    v-if="write_check === '1'"
                  >
                    <div class="blog__details__comment__item__pic">
                      <v-icon>mdi-subdirectory-arrow-right</v-icon>
                    </div>
                    <div class="blog__details__comment__item__text">
                      <h6>관리자</h6>
                      <span
                        ><v-text-field
                          label="답변을 입력해주세요."
                          v-model="insertAnswerData"
                        ></v-text-field
                      ></span>
                      <div class="blog__details__comment__btns">
                        <a @click="insertAnswer(qna.class_qna_board_code)"
                          >등록</a
                        >
                      </div>
                    </div>
                  </div>
                  <div
                    class="blog__details__comment__item blog__details__comment__item--reply"
                    v-if="
                      qna.class_qna_answer_write_content !== null &&
                        answer_check == '1'
                    "
                  >
                    <div class="blog__details__comment__item__pic">
                      <v-icon>mdi-subdirectory-arrow-right</v-icon>
                    </div>
                    <div class="blog__details__comment__item__text">
                      <h6>관리자</h6>
                      <span>{{ qna.class_qna_answer_write_content }} </span>
                    </div>
                  </div>
                  <hr />
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
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
      usertype: '',
      qnas: [],
      code: this.$route.params.id,
      user: this.$store.state.usercode,
      write_check: '0',
      answer_check: '0',
    };
  },
  async created() {
    const id = this.$route.params.id;
    this.usertype = this.$store.state.usertype;
    console.log('유저타입' + this.usertype);
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
      if (this.insertData !== '') {
        try {
          await postQnA({
            class_information_classcode: this.$route.params.id,
            class_qna_answer_write_content: '',
            class_qna_board_write_datetime: '',
            class_qna_board_code: '',
            class_qna_board_write_contents: this.insertData,
            member_nickname: '',
            member_usercode: this.$store.state.usercode,
            image_url: this.$store.state.userimg,
            answer_usercode: '',
          });
        } catch (error) {
          console.log(error);
        }

        const id = this.$route.params.id;
        this.usertype = this.$store.state.usertype;
        console.log('유저타입' + this.usertype);
        console.log(id);
        const { data } = await fetchClassQnA(id);
        this.qnas = data;
        console.log(data);

        this.insertData = '';
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
          image_url: '',
          answer_usercode: '',
        });
      } catch (error) {
        console.log(error);
      }
      const id = this.$route.params.id;
      this.usertype = this.$store.state.usertype;
      console.log('유저타입' + this.usertype);
      console.log(id);
      const { data } = await fetchClassQnA(id);
      this.qnas = data;
      console.log(data);
      this.write_check = '0';
    },
  },
};
</script>

<style scope>
a.disabled {
  pointer-events: none;
  color: #ccc;
}
.blog__details__comment .primary-btn {
  background: rgba(226, 108, 12, 0.2);
  color: #111111;
  position: absolute;
  right: 0;
  top: -12px;
}
.primary-btn {
  display: inline-block;
  font-size: 14px;
  font-weight: 600;
  text-transform: uppercase;
  padding: 14px 30px;
  letter-spacing: 2px;
}
a.disabled {
  pointer-events: none;
  color: #ccc;
}
.blog__details__comment__item__text .blog__details__comment__btns a {
  font-size: 14px;
  color: #111111;
  text-transform: uppercase;
  font-weight: 600;
  margin-right: 24px;
  position: relative;
}
</style>
