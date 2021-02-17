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
          label="댓글내용"
          required
        ></v-text-field>
        <v-btn
          :disabled="!valid"
          class="mr-4 review-btn"
          color="amber"
          @click="class_review_describe"
        >
          Submit
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
        this.$router.go(this.$router.currentRoute);
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
</style>
