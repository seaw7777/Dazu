<template>
  <div>
    <v-row>
      <v-btn @click="goList()">목록</v-btn>
      <FamousStoreUpdate :boardId="boardId"></FamousStoreUpdate>
      <v-btn
        v-if="this.detailData.member_usercode === this.$store.state.usercode"
        @click="deleteThisFamousStore()"
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
          <p>{{ comment.nickname }}({{ comment.comment_write_datetime }})</p>
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
import { getFamousStoreDetail } from '@/api/community';
import { getFamousStoreDetailComment } from '@/api/community';
import { postFamousStoreComment } from '@/api/community';
import { deleteFamousStore } from '@/api/community';
import FamousStoreUpdate from '@/components/community/FamousStoreUpdate.vue';
export default {
  components: {
    FamousStoreUpdate,
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
    const famousStoreDetail = await getFamousStoreDetail(id);
    const famousStoreComment = await getFamousStoreDetailComment(id);
    this.detailData = famousStoreDetail.data;
    this.commentList = famousStoreComment.data;
  },
  methods: {
    async postComment() {
      await postFamousStoreComment({
        board_code: this.$route.params.id,
        comment_code: '',
        comment_contents: this.commentInput,
        comment_write_datetime: '',
        member_usercode: this.$store.state.usercode,
      });
    },
    goList() {
      this.$router.push(`/community`);
    },
    async deleteThisFamousStore() {
      await deleteFamousStore(this.boardId);
      this.$router.push(`/community`);
    },
  },
};
</script>

<style></style>
