<template>
  <div>
    <div class="flex-container">
      <b-form-rating
        class="rating-form"
        v-model="rating"
        show-value
      ></b-form-rating>
      <v-form ref="form" v-model="valid" lazy-validation>
        <v-text-field
          v-model="review_content"
          :counter="50"
          label="댓글내용"
          required
        ></v-text-field>

        <v-btn
          :disabled="!valid"
          class="mr-4 review-btn"
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
.rating-form {
  widows: 100px;
}
.review-btn {
  color: blueviolet;
}
</style>
