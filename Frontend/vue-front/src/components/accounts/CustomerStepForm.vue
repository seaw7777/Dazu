<template>
  <div>
    <v-form v-model="valid">
      <v-container>
        <v-row>
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
