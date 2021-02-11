<template>
  <div>
    <v-row>
      <v-btn @click="goList()">목록</v-btn>
      <TipUpdate :boardId="boardId"></TipUpdate>
      <v-btn
        v-if="this.detailData.member_usercode === this.$store.state.usercode"
        @click="deleteThisTip()"
        >삭제</v-btn
      >
    </v-row>
    <v-card :loading="loading" class="mx-auto my-12" max-width="900">
      <template slot="progress">
        <v-progress-linear
          color="deep-purple"
          height="10"
          indeterminate
        ></v-progress-linear>
      </template>

      <v-card-title>
        <span>{{ detailData.board_title }}</span>
        <span class="grey--text">(조회수 : {{ detailData.board_visit }})</span>
      </v-card-title>

      <v-card-text>
        <v-row align="center" class="mx-0">
          <div class="grey--text">
            {{ detailData.board_write_datetime }}
          </div>
        </v-row>

        <div class="my-4 subtitle-1">작성자 : {{ detailData.nickname }}</div>

        <v-sheet color="grey lighten-4" elevation="1" height="300" width="800">
          {{ detailData.board_contents }}
        </v-sheet>
      </v-card-text>

      <v-divider class="mx-4"></v-divider>

      <v-card-title>댓글</v-card-title>

      <v-col cols="8">
        <v-row>
          <v-text-field
            label="댓글을 입력하세요."
            outlined
            clearable
            v-model="commentInput"
            @keydown.enter="postComment"
          ></v-text-field>
          <v-btn outlined color="indigo" height="55px" @click="postComment"
            >입력</v-btn
          >
        </v-row>
      </v-col>
      <v-card-text>
        <div v-for="comment in commentList" :key="comment">
          <p>
            {{ comment.nickname }}({{ comment.comment_write_datetime }})
            <!-- <v-btn
              v-if="
                this.commentList.member_usercode === this.$store.state.usercode
              "
              @click="deleteComment(comment)"
              >X</v-btn
            >
            <v-btn v-else></v-btn> -->
          </p>
          <p>{{ comment.comment_contents }}</p>
          <v-divider></v-divider>
        </div>
      </v-card-text>

      <v-card-actions>
        <v-btn color="deep-purple lighten-2" text @click="reserve">
          Reserve
        </v-btn>
      </v-card-actions>
    </v-card>
  </div>
</template>

<script>
import { getTipDetail } from '@/api/community';
import { getTipDetailComment } from '@/api/community';
import { postTipComment } from '@/api/community';
import { deleteTip } from '@/api/community';
// import { deleteTipComment } from '@/api/community';
import TipUpdate from '@/components/community/TipUpdate.vue';
export default {
  components: {
    TipUpdate,
  },
  data() {
    return {
      detailData: [],
      commentList: [],
      commentInput: '',
      boardId: Number,
    };
  },
  async created() {
    const id = this.$route.params.id;
    this.boardId = id;
    const tipDetail = await getTipDetail(id);
    const tipComment = await getTipDetailComment(id);
    this.detailData = tipDetail.data;
    this.commentList = tipComment.data;
  },
  methods: {
    async postComment() {
      await postTipComment({
        board_code: this.$route.params.id,
        comment_code: '',
        comment_contents: this.commentInput,
        comment_write_datetime: '',
        member_usercode: this.$store.state.usercode,
      });
      this.$router.go(this.$router.currentRoute);
    },
    goList() {
      this.$router.push(`/community`);
    },
    async deleteThisTip() {
      await deleteTip(this.boardId);
      this.$router.push(`/community`);
    },
    // async deleteComment(data) {
    //   console.log(typeof data.comment_code);
    //   await deleteTipComment(Number(data.comment_code));
    // },
  },
};
</script>

<style></style>
