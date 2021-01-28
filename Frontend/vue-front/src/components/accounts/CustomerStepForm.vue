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
              label="거주 중인 주소를 입력해주세요."
              required
            ></v-text-field>
          </v-col>

          <v-col cols="12">
            <v-text-field
              v-model="detailaddress"
              :counter="10"
              label="상세 주소를 입력해주세요"
              required
            ></v-text-field>
            <v-btn class="ma-2" outlined color="indigo">
              NEXT
            </v-btn>
          </v-col>
        </v-row>
      </v-container>
    </v-form>
  </div>
</template>

<script>
export default {};
</script>

<style></style>
