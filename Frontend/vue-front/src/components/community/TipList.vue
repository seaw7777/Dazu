<template>
  <div>
    <TipCreate></TipCreate>

    <v-data-table
      :headers="headers"
      :items="tipList"
      :items-per-page="5"
      class="elevation-1"
      @click:row="handleClick"
      :search="search"
      style="width: 60%"
    >
      <template v-slot:top>
        <!-- <v-row>
          <v-col cols="12" sm="6">
            <v-text-field
              v-model="search"
              label="키워드를 검색해주세요."
              class="mx-4"
            ></v-text-field>
          </v-col> -->
        <v-text-field
          v-model="search"
          label="키워드를 검색해주세요."
          class="mx-4"
        ></v-text-field>
        <!-- </v-row> -->
        <tr class="blog__details__comment__item">
          <td class="blog__details__comment__item__pic"></td>
          <td class="blog__details__comment__item__text"></td>
          <td></td>
        </tr>
      </template>
    </v-data-table>
  </div>
</template>

<script>
import { getTipList } from '@/api/community';
import TipCreate from '@/components/community/TipCreate.vue';
export default {
  components: {
    TipCreate,
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
      tipList: [],
    };
  },
  async created() {
    const tipList = await getTipList('""');
    this.tipList = tipList.data;
  },
  methods: {
    handleClick(value) {
      this.titleClick(value);
    },
    titleClick(item) {
      const id = item.board_code;
      this.$router.push(`/community/tip/detail/${id}`);
    },
  },
};
</script>

<style></style>
