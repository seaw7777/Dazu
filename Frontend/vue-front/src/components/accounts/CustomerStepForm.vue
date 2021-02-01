<template>
  <div>
    <v-form v-model="valid">
      <v-container>
        <v-row>
          <h1>고객님 추가 정보 입력 단계</h1>
          <vue-daum-postcode @complete="result = $event" />
          <div>{{ result }}</div>
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

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
import { VueDaumPostcode } from 'vue-daum-postcode';
import { customerInfoAPI } from '@/api/auth';
export default {
  data() {
    return {
      address: '',
      detailAddress: '',
      usertype: 1,
    };
  },
  components: {
    VueDaumPostcode,
  },
  methods: {
    sample4_execDaumPostcode() {
      new daum.Postcode({
        oncomplete: function(data) {
          // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

          // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
          // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
          var roadAddr = data.roadAddress; // 도로명 주소 변수
          var extraRoadAddr = ''; // 참고 항목 변수

          // 법정동명이 있을 경우 추가한다. (법정리는 제외)
          // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
          if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
            extraRoadAddr += data.bname;
          }
          // 건물명이 있고, 공동주택일 경우 추가한다.
          if (data.buildingName !== '' && data.apartment === 'Y') {
            extraRoadAddr +=
              extraRoadAddr !== ''
                ? ', ' + data.buildingName
                : data.buildingName;
          }
          // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
          if (extraRoadAddr !== '') {
            extraRoadAddr = ' (' + extraRoadAddr + ')';
          }

          // 우편번호와 주소 정보를 해당 필드에 넣는다.
          document.getElementById('sample4_postcode').value = data.zonecode;
          document.getElementById('sample4_roadAddress').value = roadAddr;
          document.getElementById('sample4_jibunAddress').value =
            data.jibunAddress;

          // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
          if (roadAddr !== '') {
            document.getElementById(
              'sample4_extraAddress',
            ).value = extraRoadAddr;
          } else {
            document.getElementById('sample4_extraAddress').value = '';
          }

          var guideTextBox = document.getElementById('guide');
          // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
          if (data.autoRoadAddress) {
            var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
            guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
            guideTextBox.style.display = 'block';
          } else if (data.autoJibunAddress) {
            var expJibunAddr = data.autoJibunAddress;
            guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
            guideTextBox.style.display = 'block';
          } else {
            guideTextBox.innerHTML = '';
            guideTextBox.style.display = 'none';
          }
        },
      }).open();
    },
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
