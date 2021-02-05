<template>
  <div>
    <v-form v-model="valid">
      <v-container>
        <v-row>
          <h1>사장님 추가 정보 입력 단계</h1>
          <v-col cols="12">
            <v-text-field
              v-model="storename"
              :counter="10"
              label="가게 이름"
              required
            ></v-text-field>
          </v-col>

          <v-col cols="12">
            <v-text-field
              v-model="address"
              :counter="10"
              label="가게 주소"
              required
            ></v-text-field>
          </v-col>

          <v-col cols="12">
            <v-text-field
              v-model="detailaddress"
              label="가게 상세 주소"
              required
            ></v-text-field>
          </v-col>
          <v-col cols="12">
            <v-icon large style="color:#d49812;">
              mdi-camera
            </v-icon>
            <v-file-input label="File input" filled></v-file-input>
          </v-col>
          <v-col cols="12">
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
