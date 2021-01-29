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
