<template>
  <div class="coming-container">
    <v-card class="mx-auto" max-width="344" outlined>
      <v-list-item three-line>
        <v-list-item-content>
          <v-list-item-title class="headline mb-1">
            {{ comingItem.class_name }}
          </v-list-item-title>
          <v-list-item-subtitle
            >{{ comingItem.class_date }}
            {{ comingItem.class_starttime.slice(0, 5) }}</v-list-item-subtitle
          >
        </v-list-item-content>

        <v-list-item-avatar tile size="80" color="grey"></v-list-item-avatar>
      </v-list-item>
    </v-card>
  </div>
</template>

<script>
export default {
  props: {
    comingItem: {
      type: Object,
    },
  },
};
</script>

<style scoped></style>
