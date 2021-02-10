<template>
  <div>
    <v-card width="600px">
      <v-card-title>가게 이름</v-card-title>
      <v-card-text>{{ this.storeName }}</v-card-text>
      <v-row justify="center">
        <v-dialog v-model="dialog" persistent max-width="290">
          <template v-slot:activator="{ on, attrs }">
            <v-btn color="primary" dark v-bind="attrs" v-on="on">
              편집
            </v-btn>
          </template>
          <v-card>
            <v-card-title class="headline">
              가게 이름 편집
            </v-card-title>
            <v-card-text
              ><v-text-field
                v-model="message1"
                label="this.storeName"
                clearable
              ></v-text-field
            ></v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="green darken-1" text @click="dialog = false">
                SAVE
              </v-btn>
              <v-btn color="green darken-1" text @click="dialog = false">
                CLOSE
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-row>
    </v-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dialog: false,
      message1: '기존값연결',
    };
  },
  props: {
    storeName: Object,
  },
};
</script>

<style></style>
