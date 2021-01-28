<template>
  <div>
    <v-form v-model="valid">
      <v-container>
        <v-row>
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
            <v-file-input
              label="File input"
              filled
              prepend-icon="mdi-camera"
            ></v-file-input>
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
