<template>
  <div>
    <div class="review-list-container">
      <div><ClassReviewForm :classdata="classdata"></ClassReviewForm></div>
      <v-list three-line>
        <template v-for="review in classreviews">
          <v-list-item :key="review.class_review_code" class="list-item">
            <v-list-item-content class="review-content">
              <ReviewStar :class_point="review.class_review_point"></ReviewStar>
              {{ review.member_nickname }}
              {{ review.class_review_point }}
              {{ review.class_review_describe }}
            </v-list-item-content>
          </v-list-item>
        </template>
      </v-list>
    </div>
  </div>
</template>

<script>
import { fetchClassReivew } from '@/api/classes';
import ReviewStar from '@/components/classes/ReviewStar.vue';
import ClassReviewForm from '@/components/classes/ClassReviewForm.vue';
export default {
  data() {
    return {
      classreviews: '',
    };
  },
  components: {
    ReviewStar,
    ClassReviewForm,
  },
  props: {
    classdata: {
      type: Object,
      required: true,
    },
  },
  async created() {
    const classId = this.$route.params.id;
    console.log(classId);
    const { data } = await fetchClassReivew(classId);
    console.log(data);
    this.classreviews = data;
  },
};
</script>

<style scoped>
.review-container {
  display: flex;
}
.review-list-container {
  display: flex;
  flex-direction: column;
  /* flex-wrap: wrap; */
  /* width: 500px; */
}
</style>
