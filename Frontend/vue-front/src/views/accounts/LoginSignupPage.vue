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
    if (this.code != undefined || this.code != null) {
      this.$store.dispatch('CODE', this.code);
      console.log('passif' + this.code);
      this.$axios
        .get('http://i4d104.p.ssafy.io:8000/dazu/login?code=' + this.code)
        .then(({ data }) => {
          this.member = data;
          console.log(JSON.stringify(data));
          console.log('member' + data);
          console.log('member' + this.member);
          this.$store.dispatch('LOGIN', this.member);
          this.$router.push('/main');
        })
        .catch(() => {
          alert('에러가 발생했습니다.');
        });
      console.log('goto main');
      this.$router.push('/main');
    }
  },
  components: {
    LoginSignBtn,
  },
  methods: {},
};
</script>

<style></style>
