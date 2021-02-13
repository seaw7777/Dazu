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
      <div>
        <v-btn @click="deleteUser">회원탈퇴</v-btn>
      </div>
    </div>
  </div>
</template>

<script>
import { deleteUser, logoutUser } from '@/api/auth';
import { deleteCookie } from '@/utils/cookies';
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
      this.$router.push(`/mystore/${this.$store.state.usercode}`);
    },
    async deleteUser() {
      const response = await deleteUser(
        this.$store.state.usercode,
        this.$store.state.token,
      );
      console.log(response);
      this.token = this.$store.state.token;
      console.log(this.token);
      await logoutUser(this.token);
      this.$store.commit('clearUsername');
      this.$store.commit('clearToken');
      this.$store.commit('clearUserimg');
      this.$store.commit('clearUserCode');
      this.$store.commit('clearUserType');
      this.$store.commit('clearStoreCode');
      deleteCookie('til_auth');
      deleteCookie('til_user');
      deleteCookie('til_img');
      deleteCookie('til_usercode');
      deleteCookie('til_usertype');
      deleteCookie('til_storecode');
      this.$router.push('/user');
    },
  },
  async created() {
    const usercode = this.$store.state.usercode;
    console.log(usercode);
    const res = await MypageOwnerInfo(usercode);
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
