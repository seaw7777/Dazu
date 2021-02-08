<template>
  <div>
    <v-data-table
      :headers="headers"
      :items="famousStoreList"
      :items-per-page="5"
      class="elevation-1"
      @click:row="handleClick"
      :search="search"
      style="width: 60%"
    >
      <template v-slot:top>
        <v-row>
          <v-col cols="12" sm="6">
            <v-text-field
              v-model="search"
              label="키워드를 검색해주세요."
              class="mx-4"
            ></v-text-field>
          </v-col>
          <FamousStoreCreate></FamousStoreCreate>
        </v-row>
      </template>
    </v-data-table>
  </div>
</template>

<script>
import { getFamousStoreList } from '@/api/community';
import FamousStoreCreate from '@/components/community/FamousStoreCreate.vue';
export default {
  components: {
    FamousStoreCreate,
  },
  data() {
    return {
      search: '',
      headers: [
        {
          text: 'No',
          align: 'start',
          sortable: false,
          value: 'board_code',
        },
        { text: '작성자', value: 'nickname', sortable: false },
        { text: '제목', value: 'board_title', sortable: false },
      ],
      famousStoreList: [],
    };
  },
  async created() {
    const famousStoreList = await getFamousStoreList('""');
    this.famousStoreList = famousStoreList.data;
  },
  methods: {
    handleClick(value) {
      this.titleClick(value);
    },
    titleClick(item) {
      const id = item.board_code;
      this.$router.push(`/community/famousstore/detail/${id}`);
    },
  },
};
</script>

<style></style>
