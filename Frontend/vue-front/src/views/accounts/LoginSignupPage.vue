<template>
  <div>
    <LoginSignBtn></LoginSignBtn>
  </div>
</template>

<script>
import LoginSignBtn from '@/components/accounts/LoginSignBtn.vue';
export default {
  data() {
    return {
      code: '',
      member: {},
    };
  },
  created() {
    this.code = this.$route.query.code;
    console.log(this.code);
    this.$axios
      .get('http://localhost:8000/dazu/login?code=' + this.code)
      .then(({ data }) => {
        this.member = data;
        console.log(this.member);
      })
      .catch(() => {
        alert('에러가 발생했습니다.');
      });
  },
  components: {
    LoginSignBtn,
  },
  methods: {},
};
</script>

<style></style>
