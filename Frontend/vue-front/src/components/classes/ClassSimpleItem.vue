<template>
  <div>
    <v-card class="mx-auto" max-width="400" @click="classclick">
      <v-img
        class="white--text align-end"
        height="200px"
        src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
      >
      </v-img>

      <v-card-text class="text--primary">
        <v-row no-gutters>
          <v-col cols="12" sm="6" md="8">
            <div>{{ classSimpleItem.class_name }}</div>
          </v-col>
          <v-col cols="6" md="4">
            <UpdateClass :classSimpleItem="classSimpleItem"></UpdateClass>
            <!-- <v-icon @click="updateClass">mdi-lead-pencil</v-icon> -->
            <v-icon @click="deleteClass">mdi-trash-can</v-icon>
          </v-col>
        </v-row>
      </v-card-text>
    </v-card>
  </div>
</template>
<script>
import UpdateClass from '@/components/stores/UpdateClass.vue';
import { deleteClass } from '@/api/classes';
export default {
  components: {
    UpdateClass,
  },
  props: {
    classSimpleItem: {
      type: Object,
      required: true,
    },
  },
  methods: {
    async deleteClass() {
      const id = this.classSimpleItem.classcode;
      await deleteClass(id);
    },
    async updateClass() {},
  },
};
</script>
<style scope></style>
