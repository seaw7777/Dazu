<template>
  <div class="owner-mypage">
    <v-avatar size="230">
      <img :src="userImgUrl" alt="this.$store.username" />
    </v-avatar>
    <div class="owner-info">
      <div>이름 : {{ userName }}</div>
      <div>주소 : {{ this.storeData.store_location }}</div>
      <div>
        <v-rating
          class="star"
          v-model="storeGrade"
          background-color="orange lighten-3"
          color="warning"
          readonly
        ></v-rating>
      </div>
      <div>가게 평점: {{ storeGrade }}</div>
      <v-btn depressed color="error" @click="gotoStoreEdit">
        나의 가게 바로가기
      </v-btn>
    </div>
  </div>
</template>

<script>
import { MypageOwnerInfo } from '@/api/mypage';

export default {
  data() {
    return {
      storeData: '',
    };
  },
  computed: {
    userImgUrl() {
      return this.$store.state.userimg;
    },
    userName() {
      return this.$store.state.username;
    },
    storeGrade() {
      return this.storeData.store_grade;
    },
  },
  methods: {
    gotoStoreEdit() {
      this.$router.push(`/mystore/${this.storeData.member_usercode}`);
    },
  },
  async created() {
    const usercode = this.$store.state.usercode;
    console.log(usercode);
    const res = await MypageOwnerInfo(3);
    console.log('사장님 가게 데이터' + JSON.stringify(res.data));
    this.storeData = res.data;
    this.$store.dispatch('STORECODE', this.storeData);
  },
};
</script>

<style scoped>
.owner-mypage {
  display: flex;
  align-items: center;
}
.owner-info {
  padding: 40px;
}
</style>
