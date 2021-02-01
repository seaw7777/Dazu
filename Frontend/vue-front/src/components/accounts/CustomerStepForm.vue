<template>
  <div>
    <v-form v-model="valid">
      <v-container>
        <v-row>
          <h1>고객님 추가 정보 입력 단계</h1>
          <v-col cols="12">
            <v-text-field
              v-model="address"
              :counter="10"
              label="거주중인 도로명 주소를 입력해주세요."
              required
            ></v-text-field>
          </v-col>

          <v-col cols="12">
            <v-text-field
              v-model="detailAddress"
              :counter="10"
              label="상세주소를 입력해주세요."
              required
            ></v-text-field>
            <v-btn class="ma-2" outlined color="indigo" @click="submitInfo">
              NEXT
            </v-btn>
          </v-col>
        </v-row>
      </v-container>
    </v-form>
  </div>
</template>

<script>
import { customerInfoAPI } from '@/api/auth';
export default {
  data() {
    return {
      address: '',
      detailAddress: '',
      usertype: 1,
    };
  },
  methods: {
    async submitInfo() {
      try {
        console.log(this.$store.state.token);
        const response = await customerInfoAPI({
          // accessToken: this.$store.state.token,
          address: this.address,
          address_detail: this.detailAddress,
          // nickname: '',
          // profileImage: '',
          usercode: '123444',
          usertype: this.usertype,
        });
        this.$router.push('/main');
        console.log(response);
      } catch (error) {
        console.log('error');
      }
    },
  },
};
</script>

<style></style>
