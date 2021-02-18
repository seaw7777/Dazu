<template>
  <div>
    <div class="review-submit">
      <v-rating
        v-model="rating"
        background-color="orange lighten-3"
        color="orange"
        size="25"
        class="rating-form"
      ></v-rating>
      <v-form ref="form" v-model="valid" lazy-validation class="reviewsubmit">
        <v-text-field
          v-model="review_content"
          label="후기를 입력해주세요."
          required
        ></v-text-field>
        <v-btn
          :disabled="!valid"
          class="mr-4 review-btn"
          style="background: rgba(226, 108, 12, 0.2);font-size: 14px;font-weight: 600;"
          elevation="0"
          large
          tile
          @click="class_review_describe"
        >
          후기등록
        </v-btn>
      </v-form>
    </div>
  </div>
</template>

<script>
import { postReview } from '@/api/classes';
export default {
  data() {
    return {
      rating: 0,
      valid: true,
      review_content: '',
    };
  },
  props: {
    classdata: {
      type: Object,
      required: true,
    },
  },

  methods: {
    async class_review_describe() {
      try {
        console.log('class코드' + this.classdata.classcode);
        const data = await postReview({
          class_review_describe: this.review_content,
          class_review_point: this.rating,
          member_nickname: this.$store.state.username,
          member_usercode: this.$store.state.usercode,
          class_information_classcode: this.classdata.classcode,
        });
        console.log('review status->' + data);
        console.log(JSON.stringify(data));
        this.rating = 0;
        this.review_content = '';
      } catch (error) {
        console.log(error);
      }
    },
  },
};
</script>

<style scoped>
.flex-container {
  display: flex;
  flex-direction: column;
}
.reviewsubmit {
  display: flex;
}
.rating-form {
  margin: 0.5rem;
}
.review-btn {
  margin-top: 0.5rem;
}
.review-submit {
  display: grid;
  grid-template-columns: 1fr 2fr;
  grid-template-areas: 'rating-form reviewsubmit';
}
.rating-form {
  grid-area: rating-form;
}
.reviewsubmit {
  grid-area: reviewsubmit;
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
</style>
