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
            <Calendars
              :classcode="classSimpleItem.classcode"
              :class_name="classSimpleItem.class_name"
            ></Calendars>
            <div v-if="classSimpleItem.mealkit_ok === '제공'">
              <Mealkits :classcode="classSimpleItem.classcode"></Mealkits>
            </div>
          </v-col>
          <v-col cols="6" md="4">
            <UpdateClass :classSimpleItem="classSimpleItem"></UpdateClass>
            <div class="my-2">
              <v-btn color="error" fab small dark @click="deleteClass">
                <v-icon>mdi-trash-can</v-icon>
              </v-btn>
            </div>
          </v-col>
        </v-row>
      </v-card-text>
    </v-card>
  </div>
</template>
<script>
import UpdateClass from '@/components/stores/UpdateClass.vue';
import Calendars from '@/components/stores/Calendars.vue';
import Mealkits from '@/components/stores/Mealkits.vue';
import { deleteClass } from '@/api/classes';
export default {
  components: {
    UpdateClass,
    Calendars,
    Mealkits,
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
  },
};
</script>
<style scope></style>
